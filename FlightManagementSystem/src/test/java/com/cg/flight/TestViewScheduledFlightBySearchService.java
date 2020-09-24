package com.cg.flight;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.flight.entity.ScheduledFlight;
import com.cg.flight.exceptions.SearchException;
import com.cg.flight.service.SearchService;

@SpringBootTest
class TestViewScheduledFlightBySearchService {

	@Autowired
	private SearchService service;
	
	@Test
	     public void testBySearchFlight() throws SearchException {
		List<ScheduledFlight> flist = service.searchFlights("DEL", "BOM",LocalDate.of(2020, 10, 9));
		Assertions.assertTrue(!flist.isEmpty());
	}
	
	@Test
    public void testBySearchFlight1() throws SearchException {
	List<ScheduledFlight> flist = service.searchFlights("MAA", "BOM",LocalDate.of(2020, 10, 11));
	Assertions.assertTrue(!flist.isEmpty());
}
	
	@Test
    public void testBySearchFlight2() throws SearchException {
	List<ScheduledFlight> flist = service.searchFlights("DEL", "BOM",LocalDate.of(2020, 10, 9));
	Assertions.assertFalse(flist.isEmpty());
}

	
	@Test
   	public void testByFlightNotFound() throws SearchException {
   		
   		Assertions.assertThrows(SearchException.class,()->service.searchFlights("KIA", "MI", LocalDate.of(2020, 9, 16)));
   	}
	
   
}