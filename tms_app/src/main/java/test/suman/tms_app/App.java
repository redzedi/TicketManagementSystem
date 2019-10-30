package test.suman.tms_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

import test.tms_domain_devTicket.DevTicketState;
import test.tms_domain_devTicket.request.PostToDevReq;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        SpringApplication.run(App.class, args);
    }
    
    @Bean
    public ObjectMapper createMapper() {
    	ObjectMapper mpr = new ObjectMapper();
    	//mpr.registerSubtypes(new NamedType(DevTicketState.class,"dev"));
    	mpr.registerSubtypes(DevTicketState.class);
    	mpr.registerSubtypes(PostToDevReq.class);
    	return mpr;
    }
}
