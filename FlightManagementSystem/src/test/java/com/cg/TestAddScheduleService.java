package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.flight.dto.ScheduleDto;
import com.cg.flight.exceptions.AirportException;
import com.cg.flight.exceptions.FlightException;
import com.cg.flight.exceptions.ScheduledIdNotFoundException;
import com.cg.flight.service.FlightScheduleService;

@SpringBootTest
public class TestAddScheduleService {
	
	@Autowired
	private FlightScheduleService flightService;
	
	@Test
	public void testAddSchedule() throws AirportException, FlightException, ScheduledIdNotFoundException {
		String expected = "AI101" + LocalDateTime.of(2020, 9, 16, 9, 00).toString();
		ScheduleDto dto = new ScheduleDto(60,LocalDateTime.of(2020, 9, 16, 9, 00), 120, "estimated", 1500, "KIA", "VTZ", "AI101");
		String actual = flightService.addFlightSchedule(dto);
		assertEquals(expected, actual);
	}
	@Test
	public void testAddSchedule2() throws AirportException, FlightException{
		ScheduleDto dto = new ScheduleDto(60,LocalDateTime.of(2020, 9, 16, 9, 00), 120, "estimated", 1500, "KIA", "VT", "AI101");
		assertThrows(AirportException.class, ()-> flightService.addFlightSchedule(dto));
	}
	@Test
	public void testAddSchedule3() throws FlightException, AirportException{
		ScheduleDto dto = new ScheduleDto(60,LocalDateTime.of(2020, 9, 16, 9, 00), 120, "estimated", 1500, "KIA", "VTZ", "A101");
		assertThrows(FlightException.class, ()-> flightService.addFlightSchedule(dto));
	}


}
