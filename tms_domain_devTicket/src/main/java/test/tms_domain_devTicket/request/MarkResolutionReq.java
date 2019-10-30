package test.tms_domain_devTicket.request;

import test.suman.tms_domain.base.InputParams;

public class MarkResolutionReq implements InputParams {

	private String completedStatus;

	public String getCompletedStatus() {
		return completedStatus;
	}

	public void setCompletedStatus(String completedStatus) {
		this.completedStatus = completedStatus;
	}
	
	
}
