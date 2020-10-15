package everis;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;	
import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.runner.JUnitCore;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.util.logging.Logger;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import everis.report.Report;
import everis.suites.KnowlerTest;

public class Application {

	public static FileSystem fileSystem = FileSystems.getDefault();
	public static JUnitCore jUnitCore = new JUnitCore();
	public static DateFormat dfNameF = new SimpleDateFormat("dd_MM_yyyy_HH_mm");
	public static String dat = dfNameF.format(new Date());
	public static String root = System.getProperty("user.dir") + fileSystem.getSeparator() + "logs";
	public static File folderLogs = new File(root + fileSystem.getSeparator() + dat);
	private static Properties prop;
	private static Pattern regex;
	private static Matcher homePage;
	private static InetAddress ping;
	private static Logger logger = Utils.logger();
	
	public static void main(String[] args) {

		folderLogs.mkdirs();
		regex = Pattern.compile(":?(http(?:s)*://)*([^:|/]*):?([0-9]*)([^$]*)");
		prop = new Properties();

		try{
			prop.load(new FileInputStream("config.properties"));
			homePage = regex.matcher(prop.getProperty("HOME_PAGE"));
			homePage.find();
			ping = InetAddress.getByName(homePage.group(2));
		} catch (Exception e) {
			logger.severe("No connection established");
		}

		jUnitCore.run(KnowlerTest.class);
		logger.info("Logs can be consulted at the following dir: " + root);
		
		logger.info("******************************** TESTCASES execution finished ********************************");
		try {
			Report.reportTestlink();
		} catch (MalformedURLException eURL) {
			logger.warning("TestLink URL is empty");
		} catch (ArrayIndexOutOfBoundsException exc) {
			logger.warning("(getTestModel) TestCaseModel is empty");
		} catch (Exception e) {
			if (e.getMessage() == null) {
			} else {
				logger.severe(e.getMessage());
			}
		}finally {
			logger.info("******************************** TESTCASES execution finished ********************************");
		}
		
	}

}