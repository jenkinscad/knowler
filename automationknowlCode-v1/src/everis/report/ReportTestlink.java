package everis.report;

import java.util.Arrays;
import java.util.Map;
import java.util.logging.Logger;

import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.model.Platform;

import everis.Utils;

public class ReportTestlink {
	public static ConectorTestlink conectorTestLink;
	private static Logger logger = Utils.logger();

	public void reportResultTestLink(JsonReport json) {
		conectorTestLink = new ConectorTestlink(json.url, json.devKey);
		
		int testCaseId = 0;
		
		ExecutionStatus status = null;
		String tracks[];
		int executionId;
		String platformName = null;

		Map<String, TestSuite> testsuites = json.testSuites;
		
		for (Map.Entry<String, TestSuite> entry : testsuites.entrySet()) {
			String testPlanName = "";
			if (entry.getValue().testSuiteTL == null) {
				testPlanName = entry.getValue().name;
			} else {
				testPlanName = entry.getValue().testSuiteTL;
			}
			
			int testPlanId = conectorTestLink.getTestPlanId(testPlanName, json.projectName);
			int buildId = conectorTestLink.getBuildIdByName(json.buildName, testPlanId);
			for (Map.Entry<String, TestCase> testcase : entry.getValue().testCases.entrySet()) {
				for (int i = 0; i < testcase.getValue().result.length;i++) {
					testCaseId = conectorTestLink.getTestCaseId(testcase.getValue().externalId);
					if (testcase.getValue().result[0].contains("KO")) {
						status = ExecutionStatus.FAILED;
					} else if (testcase.getValue().result[0].contains("OK")) {
						status = ExecutionStatus.PASSED;
					} else {
						status = ExecutionStatus.BLOCKED;
					}
				}

				tracks = new String[testcase.getValue().notes.size()];
				for (int i = 0; i < testcase.getValue().notes.size(); i++) {
					tracks[i] = testcase.getValue().notes.get(i);
				}

				try {
					Platform[] testplanplatforms = conectorTestLink.getTestPlanPlatforms(testPlanId);
					for (int i = 0; i < testplanplatforms.length; i++) {
						String platformNameConfigured = testplanplatforms[i].getName();
						if (platformNameConfigured.equals(json.platform)) {
							platformName = json.platform;
						}
					} 				
				} catch (Exception e) {
					logger.severe("Testlink Report: " + e.getMessage());
				}					

				String preparedTracks = (Arrays.toString(tracks));

				try {
					conectorTestLink.reportResult(testCaseId, testPlanId, buildId, status, preparedTracks, platformName);
					executionId = conectorTestLink.getlastExecution(testPlanId, testCaseId, buildId);
					for (int i = 0; i < testcase.getValue().screenShootsPaths.size(); i++) {
						try {
							conectorTestLink.addAttachmentsForTestCase(testcase.getValue().screenShootsPaths.get(i),
									executionId, testcase.getValue().name, testcase.getValue().name, testcase.getValue().name,
									"image/png");
						} catch (Exception e) {
							logger.severe(e.getMessage());
						}
					}
					
				} catch (Exception e) {
					logger.severe("Testlink Report: " + e.getMessage());
				}
			}
		}
	}
}