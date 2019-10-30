package test.tms_domain_devTicket.request;

import test.suman.tms_domain.base.InputParams;

public class PostToQAReq implements InputParams {

	private String qaTeamTargetType;
	private String qaTeamTargetName;
	public String getQaTeamTargetType() {
		return qaTeamTargetType;
	}
	public void setQaTeamTargetType(String qaTeamTargetType) {
		this.qaTeamTargetType = qaTeamTargetType;
	}
	public String getQaTeamTargetName() {
		return qaTeamTargetName;
	}
	public void setQaTeamTargetName(String qaTeamTargetName) {
		this.qaTeamTargetName = qaTeamTargetName;
	}
	
	
}
