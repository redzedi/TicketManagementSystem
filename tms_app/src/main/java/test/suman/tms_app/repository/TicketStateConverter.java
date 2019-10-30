package test.suman.tms_app.repository;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import test.suman.tms_domain.base.TicketState;
import test.tms_domain_devTicket.DevTicketState;

@Converter(autoApply=true)
public class TicketStateConverter  implements AttributeConverter<TicketState,String>{

	@Override
	public String convertToDatabaseColumn(TicketState attribute) {
		// TODO Auto-generated method stub
		return attribute.getName();
	}

	@Override
	public TicketState convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		return DevTicketState.valueOf(dbData);
	}

}
