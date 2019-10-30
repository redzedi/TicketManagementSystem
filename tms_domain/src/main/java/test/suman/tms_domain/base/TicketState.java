package test.suman.tms_domain.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;


@JsonTypeInfo(use=Id.NAME,include=As.WRAPPER_ARRAY)
public interface TicketState {

	public default void doExecute(TicketContext ctx,  InputParams ip) {
		
		TicketState targetState = this.doInvokeActions( ctx,    ip);
		
		ctx.setState(targetState);
	}
	
	TicketState doInvokeActions(TicketContext ctx,  InputParams ip);
	

	 //needed for db
	 String getName();
	 
	 TicketState getFromName(String name);
	 
}
