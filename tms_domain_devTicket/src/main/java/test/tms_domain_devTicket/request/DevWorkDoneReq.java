package test.tms_domain_devTicket.request;

import test.suman.tms_domain.base.InputParams;

public class DevWorkDoneReq implements InputParams {
	
	private String commitHash;
	private String comment;
	public String getCommitHash() {
		return commitHash;
	}
	public void setCommitHash(String commitHash) {
		this.commitHash = commitHash;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
