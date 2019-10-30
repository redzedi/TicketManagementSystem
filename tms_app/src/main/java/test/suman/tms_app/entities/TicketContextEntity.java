package test.suman.tms_app.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import test.suman.tms_domain.base.InputParams;
import test.suman.tms_domain.base.TicketContext;
import test.suman.tms_domain.base.TicketState;


@Entity
public class TicketContextEntity implements TicketContext {
	
	@GeneratedValue
	@Id
	private Integer id;

	@JsonProperty
	@Column(name="attributeValue")
	@MapKeyColumn(name="attributeName")
	@CollectionTable(name="TicketAttributeValue")
	@ElementCollection
	private Map<String,String> ticketAttributeValueMap = new HashMap<String,String>();
	
	
	@NotNull
	private TicketState currentState;
	
	
	

	

	@Override
	public TicketState getState() {
		// TODO Auto-generated method stub
		return currentState;
	}

	@Override
	public void setState(TicketState state) {
		this.currentState = state;
		
	}

	
	@Override
	public void setAttributeValue(String attributeName, String val) {
		this.ticketAttributeValueMap.put(attributeName, val);
		
	}

	@Override
	public String getAttributeValue(String attributeName) {
		return this.ticketAttributeValueMap.get(attributeName);
	}
	
	

	public Integer getId() {
		return id;
	}

	@Override
	public TicketContextEntity execute(InputParams ip) {
		this.currentState.doExecute(this,  ip);
		return this;
		
	}
	
	

}
