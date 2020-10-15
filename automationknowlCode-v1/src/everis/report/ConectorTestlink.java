package everis.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

import org.apache.commons.codec.binary.Base64;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.model.Attachment;
import br.eti.kinoshita.testlinkjavaapi.model.Build;
import br.eti.kinoshita.testlinkjavaapi.model.Platform;
import br.eti.kinoshita.testlinkjavaapi.model.ReportTCResultResponse;
import br.eti.kinoshita.testlinkjavaapi.model.TestCase;
import br.eti.kinoshita.testlinkjavaapi.model.TestPlan;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;
import everis.Utils;

public class ConectorTestlink {
	private TestLinkAPI api = null;
    private URL testlinkURL = null;
    private static Logger logger = Utils.logger();
	
	public ConectorTestlink(String url, String devKey) {
			
        try {
            this.testlinkURL = new URL(url);
        } catch (MalformedURLException e) {
            logger.severe(e.getMessage());
        }

        try {
            this.api = new TestLinkAPI(testlinkURL, devKey);
            this.api.checkDevKey(devKey);
        } catch (TestLinkAPIException e) {
        	if (e.getCause() == null) {
                logger.severe(e.getMessage());
            } else {
                logger.severe(e.getCause().getMessage());
            }      
        }
        
    }
    
    public TestPlan getTestPlanByName(String testPlanName, String projectName) {
        return this.api.getTestPlanByName(testPlanName, projectName);
    }
        
    public Integer getTestPlanId(String testPlanName, String projectName) {
        TestPlan testPlan = this.getTestPlanByName(testPlanName, projectName);
        return testPlan.getId();
    }
        
    public Build[] getBuildsByTestPlan(int testPlanId) {
        return this.api.getBuildsForTestPlan(testPlanId);
    }

    public Build createBuild(Integer testPlanId, String buildName) {
		return this.api.createBuild(testPlanId, buildName, null);
    }
    
    public Platform[] getTestPlanPlatforms(int testPlanId) {
    	return this.api.getTestPlanPlatforms(testPlanId);
    }
        
    public Integer getBuildIdByName(String buildName, int testPlanId) {
        Integer buildId = null;
        
        Build[]buildsByTestPlan = this.getBuildsByTestPlan(testPlanId);

        if (buildsByTestPlan == null) {
			this.createBuild(testPlanId, buildName);
			buildsByTestPlan = this.getBuildsByTestPlan(testPlanId);
        }
        
        for (Build build:buildsByTestPlan) {
            try {
                if (buildName.contains(build.getName())) {
					buildId = build.getId();
                }
            } catch (Exception e) {
                e.printStackTrace(System.err);
                System.exit(-1);
            }
        }
        if (buildId == null) {
			Build createBuild = this.createBuild(testPlanId, buildName);
			buildId = createBuild.getId();
        }
        return buildId;		
    }
        
    public TestCase getTescaseInfo(String fullTestCaseExternalId, Integer version) {
        return this.api.getTestCaseByExternalId(fullTestCaseExternalId, version);
        
    }
        
    public Integer getTestCaseId(String fullTestCaseExternalId) {
        TestCase testCaseId = this.getTescaseInfo(fullTestCaseExternalId, null);
        return testCaseId.getId();
    }
        
    public void reportResult(Integer testCaseId, Integer testPlanId,Integer buildId, ExecutionStatus status, 
            String tracksNotes, String platformName) {
        ReportTCResultResponse reportTcExecution = this.api.reportTCResult(testCaseId, null, testPlanId, 
                status, null, buildId, null, tracksNotes, null, null, null, null, platformName, 
                null, null, null, null);
        logger.info("Result test case report: " + reportTcExecution.getMessage());
    }

    public Integer getlastExecution(Integer testPlanId, Integer testCaseId, Integer buildId) {
		return this.api.getLastExecutionResult(testPlanId, testCaseId, null, null, null, buildId, null, null).getId();
    }
    
    public void addAttachmentsForTestCase(String filePath, Integer executionId, String title, String description,
        String fileName, String fileType) throws TestLinkAPIException {
        Base64 base64 = new Base64();
        File attachment = new File(filePath);
        byte [] byteArray = new byte[(int) attachment.length()];
        InputStream inputStream;
        String fileContent = null;
        
        try {
            inputStream = new FileInputStream(attachment);
            inputStream.read(byteArray);
            fileContent = base64.encodeToString(byteArray);
        } catch (IOException e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
        
        Attachment preparedAttachment = api.uploadExecutionAttachment(executionId, title, description, fileName, fileType, fileContent);
        logger.info("upload file success");
    }
}