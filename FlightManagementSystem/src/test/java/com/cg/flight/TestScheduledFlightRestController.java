package com.cg.flight;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cg.flight.entity.ScheduledFlight;

@SpringBootTest
public class TestScheduledFlightRestController {
	
	private RestTemplate rt = new RestTemplate();
	
	@Test
	public void testViewScheduledFlight() {
		String url ="http://localhost:8082/flightManagement/search/DEL/BOM/2020-10-09";
		ResponseEntity<List<ScheduledFlight>> resp = 
				rt.exchange(url,HttpMethod.GET,null, new ParameterizedTypeReference<List<ScheduledFlight>>(){} );
		assertFalse(resp.getBody().isEmpty());
	}
	
	@Test
	public void testViewScheduledFlight2() {
		String url ="http://localhost:8082/flightManagement/search/MAA/BOM/2020-10-10";
		
		assertThrows(HttpClientErrorException.class, 
				()-> rt.exchange(url,HttpMethod.GET,null, new ParameterizedTypeReference<List<ScheduledFlight>>(){} ));
		
    }
}
