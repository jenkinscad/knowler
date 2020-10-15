package everis.report;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;
import everis.Utils;

public class Report {

	private static FileSystem fileSystem = FileSystems.getDefault();
	private static String root = System.getProperty("user.dir") + fileSystem.getSeparator() + "logs";
	private static File rootFile = new File(root);
	private static Properties prop;
	private static Logger logger = Utils.logger();
	private static JsonReport jsonReport = new JsonReport();
	private static HashMap<String, ArrayList> notes = new HashMap<>();
	private static HashMap<String, ArrayList> screenShootsPaths = new HashMap<>();

	public static void addResults(String suiteName, String caseName, String results[]) {
		TestSuite testSuite = jsonReport.testSuites.get(suiteName);
		if (testSuite == null ) testSuite =  new TestSuite(suiteName);
		
		TestCase testCase = new TestCase(caseName, results , notes.get(caseName), screenShootsPaths.get(caseName));
		testSuite.testCases.put(caseName, testCase);
		prop = new Properties();
		try {
			prop.load(new FileInputStream("config.properties"));
			
		} catch (FileNotFoundException e) {
			logger.severe(e.getMessage());
		} catch (IOException e) {
			logger.severe(e.getMessage());
		}

		jsonReport.testSuites.put(suiteName, testSuite);
		jsonReport.aLtestSuites.add(testSuite);
		
		jsonReport.url = prop.getProperty("TESTLINK");
		jsonReport.devKey = prop.getProperty("APIKEY");
		jsonReport.projectName = prop.getProperty("PROJECT_NAME_TESTLINK");
		jsonReport.buildName = prop.getProperty("BUILD_NAME");
		jsonReport.platform = prop.getProperty("PLATFORM_NAME");
	
	}

	public static void reportExcel(File route) {
		rootFile.mkdirs();
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(Calendar.getInstance().getTime());
		String[] columnsExcel = { "Test Case Name", "Result" };
		HSSFWorkbook wk = null;

		Font fontHeader = null;
		CellStyle styleHeader = null;
		try {
			wk = null;

			File file = new File(route + fileSystem.getSeparator() + "ReportResult_" + timeStamp + ".xls");
			FileInputStream fis = null;

			if (file.exists()) {
				fis = new FileInputStream(file);
				wk = (HSSFWorkbook) WorkbookFactory.create(fis);

			} else {
				wk = new HSSFWorkbook();
			}
			
			fontHeader = wk.createFont();
			fontHeader.setBold(true);
			fontHeader.setFontHeightInPoints((short) 11);

			styleHeader = wk.createCellStyle();
			styleHeader.setFont(fontHeader);

			if (fis != null) {
				fis.close();
			}
		} catch (Exception e) {
			logger.severe(e.getMessage());
		}

		for (TestSuite ts : jsonReport.aLtestSuites) {
			TestSuite lastTs = jsonReport.aLtestSuites.get(jsonReport.aLtestSuites.size()-1);
			int rowNumber = 0;
			for (String caseName : lastTs.testCases.keySet()) {
				rowNumber++;
				TestCase testCase = lastTs.testCases.get(caseName);
				HSSFSheet sheet = null;
				try {
					sheet = wk.getSheet(lastTs.name);
					if (sheet == null) {
						sheet = wk.createSheet(lastTs.name);
					}

					Row header = sheet.createRow(0);

					for (int i = 0; i < columnsExcel.length; i++) {
						Cell cell = header.createCell(i);
						cell.setCellValue(columnsExcel[i]);
						cell.setCellStyle(styleHeader);
					}

					CellStyle styleResult = wk.createCellStyle();

					Row row = sheet.createRow(rowNumber);
					row.createCell(0).setCellValue(testCase.name);
					styleResult.setFillPattern(FillPatternType.SOLID_FOREGROUND);
					for (int i = 0, resultsLength = testCase.result.length; i < resultsLength; i++) {
						String result = testCase.result[i];
						if (result.equals("KO")) {
							styleResult.setFillForegroundColor(IndexedColors.CORAL.getIndex());
						} else if (result.equals("OK")) {
							styleResult.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
						} else {
							styleResult.setFillForegroundColor(IndexedColors.AQUA.getIndex());
						}
						Cell cell = row.createCell(i + 1);

						if (i > 0) {
							Cell nameIteration = header.createCell(i + 1);
							nameIteration.setCellValue("Iteration " + i);
							nameIteration.setCellStyle(styleHeader);
						}

						cell.setCellValue(result);
						cell.setCellStyle(styleResult);
						sheet.autoSizeColumn(i);
					}

					FileOutputStream fileOut = new FileOutputStream(route + fileSystem.getSeparator() + "ReportResult_" + timeStamp + ".xls");
					wk.write(fileOut);
					fileOut.close();
					wk.close();
				} catch (Exception e) {
					logger.severe(e.getMessage());
				}
			}
		}
	}
	
	public static void reportLog(String result, File route, String script, String msg, String log, String level, int wait, WebDriver driver) {
		rootFile.mkdirs();
		Report.capScreen(result, route, driver ,script);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		try {
			String logPath = route + fileSystem.getSeparator() + "Log_" + script + ".log";
			File logFile = new File(logPath);
			FileWriter fw = new FileWriter(logFile, true);
			if (log.equals("DEBUG") && !level.equals("DEBUG")) {
				fw.write(df.format(new Date()) + " - " + "INFO" + " - " + "More info changing LOG_LEVEL in confing.properties file\r\n");
			}else {
				fw.write(df.format(new Date()) + " - " + log + " - " + msg + "\r\n");
			}
			
			if (wait > 0) {
				fw.write(df.format(new Date()) + " - " + log + " - " + "Thread sleep " + wait + "ms" + "\r\n");
			}
			ArrayList<String>addNotes = notes.get(script);
			if (addNotes == null) {
				addNotes = new ArrayList<>();
				notes.put(script, addNotes);
			}

			addNotes.add(df.format(new Date()) + " - " + level + " - " + msg + "\r\n");
	
			fw.close();

		} catch (SecurityException | IOException e) {
			logger.severe(e.getMessage());
		}

	}

	public static void capScreen(String result, File route, WebDriver driver , String script) {
		String timeStamp = new SimpleDateFormat("HH.mm.ss.SSS").format(Calendar.getInstance().getTime());
		String name = result + "_" + script;
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourcePath = ts.getScreenshotAs(OutputType.FILE);
		File folderScreen = new File(route + fileSystem.getSeparator() + "screenshots");
		folderScreen.mkdir();
		String path = folderScreen + fileSystem.getSeparator() + name + "_" + timeStamp + ".png";
		ArrayList<String>addScreenShoot = screenShootsPaths.get(script);
		if (addScreenShoot == null) {
			addScreenShoot = new ArrayList<>();
			screenShootsPaths.put(script, addScreenShoot);
		}
		
		addScreenShoot.add(path);
	

		File destination = new File(path);

		try {
			Files.copy(sourcePath, destination);
		} catch (Exception e) {
			logger.severe(e.getMessage());
		}
	}

	
	public static void reportTestlink() throws MalformedURLException{
		if (jsonReport.url.contains("url")) {
			logger.warning("testlink report not configured");	
		} else if (StringUtils.isBlank(jsonReport.url)) {
			throw new MalformedURLException();
		} else {
			ReportTestlink reportTestlink = new ReportTestlink();
			reportTestlink.reportResultTestLink(jsonReport);
		}
	}
	
}
