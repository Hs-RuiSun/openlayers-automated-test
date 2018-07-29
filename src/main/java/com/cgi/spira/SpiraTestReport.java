package com.cgi.spira;

import java.util.Date;

import com.inflectra.spiratest.addons.junitextension.SpiraTestExecute;
import com.inflectra.spiratest.addons.junitextension.soap.IImportExportDocumentAddFileServiceFaultMessageFaultFaultMessage;

public class SpiraTestReport {
	public static void generateReport() throws IImportExportDocumentAddFileServiceFaultMessageFaultFaultMessage {
		Integer testerUserId;
		int testCaseId;
		Integer releaseId;
		Integer testSetId;
		Date startDate;
		Date endDate;
		int executionStatusId;
		String runnerName;
		String runnerTestName;
		int runnerAssertCount;
		String runnerMessage;
		String runnerStackTrace;
		//SpiraTestExecute.recordTestRun(testerUserId, testCaseId, releaseId, testSetId, startDate, endDate,
          //      executionStatusId, runnerName, runnerTestName, runnerAssertCount, runnerMessage, runnerStackTrace);
	}
}
