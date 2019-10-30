package test.tms_domain_devTicket.request;

import com.fasterxml.jackson.annotation.JsonTypeName;

import test.suman.tms_domain.base.InputParams;


@JsonTypeName("dev_PostToDevReq")
public class PostToDevReq implements InputParams {
	
	private String devTargetType;
	private String devTargetName;
	public String getDevTargetType() {
		return devTargetType;
	}
	public void setDevTargetType(String devTargetType) {
		this.devTargetType = devTargetType;
	}
	public String getDevTargetName() {
		return devTargetName;
	}
	public void setDevTargetName(String devTargetName) {
		this.devTargetName = devTargetName;
	}
	
	

}
