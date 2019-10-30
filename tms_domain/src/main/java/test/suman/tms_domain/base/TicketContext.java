package test.suman.tms_domain.base;

public interface TicketContext {
	
	public TicketState getState();
	public void setState(TicketState state);
	
	public void setAttributeValue(String attributeName,String val);
	public String getAttributeValue(String attributeName);
	
	public TicketContext execute(InputParams ip);

}
