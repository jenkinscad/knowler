package everis.report;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import everis.Utils;

public class TestSuite {
	public static Properties prop;
	public String name;
	public String testSuiteTL;
	public Map<String, TestCase> testCases = new HashMap();
	private static Logger logger = Utils.logger();

	public TestSuite(String name) {
		prop = new Properties();
		try {
			prop.load(new FileInputStream("config.properties"));
		} catch (IOException e) {
			logger.severe(e.getMessage());
		}
		this.name = name;
		this.testSuiteTL = prop.getProperty(this.name);
	}
}