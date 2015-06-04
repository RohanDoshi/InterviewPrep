package com.railroad.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.railroad.exceptions.NoSuchRouteExistsException;
import com.railroad.exceptions.NoSuchTownExistsException;
import com.railroad.service.RailRoadService;
import com.railroad.service.RailRoadServiceImpl;

/*
 * 
 * @Date : 05/10/2015
 * @Author : Rohan Doshi
 * 
 */

public class RailRoadServiceTest {

	private RailRoadService railRoadService; 
	private static final String railRoadMap = "AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7";
	
	@Before
	public void setup() {
		railRoadService = new RailRoadServiceImpl(railRoadMap);	
	}
	
	@Test
	public void testGetTotalDistance() {
		String distance = railRoadService.getTotalDistance("A-B-C");
		assertTrue(distance.equals("9.0"));
	}
	
	@Test
	public void testGetTotalDistanceNoRoute() {
		String distance = railRoadService.getTotalDistance("A-E-D");
		assertTrue(distance.equals("NO SUCH ROUTE"));
	}
	
	@Test(expected = NoSuchTownExistsException.class)
	public void testGetTotalDistanceNoTown() {
		railRoadService.getTotalDistance("A-F");
	}
	
	@Test
	public void testIsRouteExist() {
		assertTrue(railRoadService.isRouteExist('C', 'D'));
	}
	
	@Test
	public void testIsRouteNotExist() {
		assertFalse(railRoadService.isRouteExist('A', 'C'));
	}
	
	@Test
	public void testGetNumberOfRoutesDistanceLessThan() {
		assertTrue(railRoadService.getNumberOfRoutesDistanceLessThan('C', 'C', 30) == 7);
		assertTrue(railRoadService.getNumberOfRoutesDistanceLessThan('C', 'C', 0) == 0);
		assertTrue(railRoadService.getNumberOfRoutesDistanceLessThan('C', 'C', -10) == 0);
	}
	
	@Test
	public void testGetNumberOfRoutesExactNumOfStops() {
		assertTrue(railRoadService.getNumberOfRoutesExactNumStops('A', 'C', 4) == 3);
		assertTrue(railRoadService.getNumberOfRoutesExactNumStops('C', 'C', 3) == 1); // C-E-B-C
		assertTrue(railRoadService.getNumberOfRoutesExactNumStops('A', 'A', 1) == 0);
	}
	
	@Test
	public void testGetShortestDistance() {
		assertTrue(railRoadService.getShortestDistance('A', 'C') == 9);
		assertTrue(railRoadService.getShortestDistance('B', 'B') == 9);
	}
	
	@Test(expected = NoSuchRouteExistsException.class)
	public void testGetShortestDistanceNoRoute() {
		railRoadService.getShortestDistance('B', 'A');
	}
}
