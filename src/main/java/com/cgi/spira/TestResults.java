package com.cgi.spira;

import java.io.IOException;
import java.util.Date;

import com.inflectra.spiratest.addons.junitextension.SpiraTestExecute;
import com.inflectra.spiratest.addons.junitextension.commons.Commons;
import com.inflectra.spiratest.addons.junitextension.commons.JsonData;
import com.inflectra.spiratest.addons.junitextension.soap.IImportExportDocumentAddFileServiceFaultMessageFaultFaultMessage;

public class TestResults extends Commons {
    public static void testResults()
            throws IOException, IImportExportDocumentAddFileServiceFaultMessageFaultFaultMessage {
        try {
            Date now = new Date();
            Integer testerUserId = 5;
            int testCaseId = JsonData.caseID;
            Integer releaseId = null;
            Integer testSetId = JsonData.runID;
            Date startDate = now;
            Date endDate = now;
            int executionStatusId;

            if (junitTestResult == null) {
                System.out.println("JUnit Results Never Ran");
                executionStatusId = 5;
            }
            else {
                if (junitTestResult.getFailureCount() == 0) {
                    executionStatusId = 2;
                    System.out.println("\n<PASSED>\n");
                }
                else {
                    executionStatusId = 1;
                    System.out.println("\n<FAILED>\n");
                }
            }
            
            System.out.println("[END TEST CASE]: " + JsonData.Scenario + ":" + JsonData.title + "\n");

            String runnerName = JsonData.spiraUser;
            String runnerStackTrace = spiraTestResult;
            String runnerMessage = null;
            int runnerAssertCount = 0;
            String runnerTestName = JsonData.title;
            System.out.println("Publish results to Spira...");
            SpiraTestExecute.recordTestRun(testerUserId, testCaseId, releaseId, testSetId, startDate, endDate,
                    executionStatusId, runnerName, runnerTestName, runnerAssertCount, runnerMessage, runnerStackTrace);

            System.out.println("Spira Results Published!");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
