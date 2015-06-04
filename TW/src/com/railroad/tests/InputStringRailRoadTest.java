package com.railroad.tests;

import org.junit.Test;

import com.railroad.exceptions.InputStringInvalidException;
import com.railroad.service.RailRoadService;
import com.railroad.service.RailRoadServiceImpl;

/*
 * 
 * @Date : 05/10/2015
 * @Author : Rohan Doshi
 * 
 */
public class InputStringRailRoadTest {
	private static final String correctInput = "AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7";
	private static final String sameRouteInput = "AB5,AB4,CD8,DC8,DE6,AD5,CE2,EB3,AE7";
	private static final String sameTownInput = "AA5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7";
	private RailRoadService  railRoadService = null;
	
	@Test
	public void testRailRoadInput() {
		railRoadService = new RailRoadServiceImpl(correctInput);
	}
	
	@Test(expected = InputStringInvalidException.class) 
	public void testRailRoadInputSameRoute() {
		railRoadService = new RailRoadServiceImpl(sameRouteInput);
	}
	
	@Test(expected = InputStringInvalidException.class)
	public void testRailRoadInputSameTown() {
		railRoadService = new RailRoadServiceImpl(sameTownInput);
	}
}
