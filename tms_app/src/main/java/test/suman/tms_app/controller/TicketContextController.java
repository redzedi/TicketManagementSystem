package test.suman.tms_app.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import test.suman.tms_app.entities.TicketContextEntity;
import test.suman.tms_app.repository.TicketContextRepository;
import test.suman.tms_domain.base.InputParams;

@RestController
public class TicketContextController {
	
	@Autowired
	private TicketContextRepository repo;
	
	@RequestMapping(path="/tickets",method=RequestMethod.GET)
	public List<TicketContextEntity> listTickets() {
	   return repo.findAll();	
	}
	
	@RequestMapping(path="/tickets",method=RequestMethod.POST)
	public ResponseEntity saveTicket(@RequestBody TicketContextEntity tkt) throws Exception {
		//TicketContextEntity tkt = new ObjectMapper().readValue(tkt1,TicketContextEntity.class);
	   TicketContextEntity createdTkt =  repo.save(tkt);	
	   
	   return ResponseEntity.created(new URI("http://localhost:8080/tickets/"+createdTkt.getId())).build();
	}
	
	@RequestMapping(path="/tickets/{id}",method=RequestMethod.GET)
	public TicketContextEntity getTicketById(@PathVariable("id") Integer tktId) {
	   return repo.findById(tktId).orElseThrow(()-> new RuntimeException("TicketNotFound"));	
	}
	
	@RequestMapping(path="/tickets/{id}/execute",method=RequestMethod.POST)
	public TicketContextEntity executeTransition(@PathVariable("id") Integer tktId , @RequestBody InputParams ip) throws Exception {
	   TicketContextEntity updatedTicket =  repo.findById(tktId).orElseThrow(()-> new RuntimeException("TicketNotFound")).execute(ip);
	   repo.save(updatedTicket);
	   
	   return updatedTicket;
	}
	
	@RequestMapping(path="/tickets/{id}",method=RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable("id") Integer tktId) {
	    repo.deleteById(tktId);
	    return ResponseEntity.noContent().build();
	}
	

}
