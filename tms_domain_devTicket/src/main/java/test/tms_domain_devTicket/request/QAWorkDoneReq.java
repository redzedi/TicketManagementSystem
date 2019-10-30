package test.tms_domain_devTicket.request;

import test.suman.tms_domain.base.InputParams;

public class QAWorkDoneReq implements InputParams {
	
	private boolean isQAPassed;
	private String qaComment;
	public boolean isQAPassed() {
		return isQAPassed;
	}
	public void setQAPassed(boolean isQAPassed) {
		this.isQAPassed = isQAPassed;
	}
	public String getQaComment() {
		return qaComment;
	}
	public void setQaComment(String qaComment) {
		this.qaComment = qaComment;
	}
	
	

}
