package everis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.ErrorManager;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utils {

    private static boolean check = true;
    private static Logger logger = Logger.getLogger(Application.class.getName());
    private static Handler consoleHandler = initHandler();

    public static HashMap readExcel(String path) throws IOException {
        HashMap<String, ArrayList<HashMap<String, String>>> sheetList = new HashMap();

        try (FileInputStream fis = new FileInputStream(path)) {
            Workbook wb = WorkbookFactory.create(fis);
            DataFormatter df = new DataFormatter();
            
            int sheets = wb.getNumberOfSheets();
            
            for (int i = 0; i < sheets; i++) {
                Sheet sheet = wb.getSheetAt(i);
                ArrayList<HashMap<String, String>> rowList = new ArrayList();
                sheetList.put(sheet.getSheetName(), rowList);
                
                Iterator<Row> rows = sheet.iterator();
                
                Row keys = rows.next();
                int cols = keys.getPhysicalNumberOfCells();
                
                while (rows.hasNext()) {
                    Row row = rows.next();
                    HashMap<String, String> rowContent = new HashMap();
                    rowList.add(rowContent);
                  
                    for (int c = 0; c < cols; c++) {
                        String value = df.formatCellValue(row.getCell(c));
                        String key = df.formatCellValue(keys.getCell(c));
                        rowContent.put(key + ":" + sheet.getSheetName(), value);
                    }
                    
                }
                
            }

            

            wb.close();
        } catch (Exception e) { }

        if (!check) {
            return null;
        }
        
        return sheetList;
    }

    static ArrayList getTabs(String tabString, HashMap<String, ArrayList<HashMap<String, String>>> sheetList) {
        String[] tabs = tabString.split(":");
        ArrayList<HashMap<String, String>> rowList = new ArrayList();
        
        if (validateExcel(0, sheetList, tabs, "")) {
            rowList = getRows(tabs, rowList, sheetList);
        } else {
            check = false;
        }
        
        return rowList;
    }
    
    static ArrayList getRows(String[] tabs, ArrayList<HashMap<String, String>> rowList, HashMap<String, ArrayList<HashMap<String, String>>> sheetList) {
        ArrayList<HashMap<String, String>> newRows = new ArrayList();
        for (int i = 0; i < sheetList.get(tabs[0]).size(); i++) {
            HashMap<String, String> newRow = new HashMap();
            for (String tab : tabs) {
                Iterator<String> iterator = sheetList.get(tab).get(i).keySet().iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    
                    if (!validateExcel(1, sheetList, tabs, sheetList.get(tab).get(i).get(key).toString())) {
                        check = false;
                    }
                    
                    newRow.put(key, sheetList.get(tab).get(i).get(key).toString());
                }
            }
            newRows.add(newRow);
        }
        return newRows;
    }

    static boolean validateExcel(int validation, HashMap<String, ArrayList<HashMap<String, String>>> sheetList, String[] tabs, String valueCol) {
        switch (validation) {
            case 0:
                for (int i = 0; i < tabs.length; i++) {
                    if (sheetList.get(tabs[0]).size() != sheetList.get(tabs[i]).size()) {
                        logger.warning("Data sheets do not have the same number of rows");
                        return false;
                    }
                }
                break;
            case 1:
                if (valueCol == "") {
                    logger.warning("Some columns in data sheet are empty");
                    return false;
                }
                break;
            default:
                logger.severe("Can't find data sheet file");
                return false;
        }
        
        return true;
    }
    
    public static boolean isElementEnabled(WebElement x, WebDriver driver) {

        turnOffImplicitWaits(driver);
        boolean result = x.isEnabled();
        turnOnImplicitWaits(driver);
        return result;
    }

    private static void turnOffImplicitWaits(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    private static void turnOnImplicitWaits(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static Handler initHandler() {
        return new Handler() {
            @Override
            public void publish(LogRecord record) {
                if (getFormatter() == null) {
                    setFormatter(new SimpleFormatter());
                }

                try {
                    String message = getFormatter().format(record);
                    if (record.getLevel().intValue() >= Level.WARNING.intValue()) {
                        System.err.write(message.getBytes());
                    } else {
                        System.out.write(message.getBytes());
                    }
                } catch (Exception exception) {
                    reportError(null, exception, ErrorManager.FORMAT_FAILURE);
                }

            }

            @Override
            public void close() throws SecurityException {
            }

            @Override
            public void flush() {
            }
        };
    }

    public static Logger logger() {
        for (Handler handler : logger.getHandlers()) {
            logger.removeHandler(handler);
        }
        logger = Logger.getLogger(Application.class.getName());
        logger.setUseParentHandlers(false);
        logger.addHandler(consoleHandler);
        return logger;
    }

    public static WebDriver setUpDriver(File folderDownloads, Properties prop, String nameDriver, Map<String, WebDriver> contextsDriver) throws Exception {
        WebDriver driver;
        if (contextsDriver.get(nameDriver) != null) { driver = contextsDriver.get(nameDriver); }
        else {
            String driverPath = prop.getProperty("DRIVER");
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", folderDownloads.getAbsolutePath());
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            
            contextsDriver.put(nameDriver, driver);
        }
        
        return driver;
    }
}