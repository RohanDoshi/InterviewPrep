package com.railroad.main;

import com.railroad.service.RailRoadService;
import com.railroad.service.RailRoadServiceImpl;

/*
 * 
 * @Date : 05/10/2015
 * @Author : Rohan Doshi
 * 
 */
public class Application {
	
	public static void main(String args[]) throws Exception {
		if(args.length == 0) {
			throw new Exception("No input provided !");
		}
		RailRoadService railRoadService = new RailRoadServiceImpl(args[0]);
		System.out.println(railRoadService.getTotalDistance("A-B-C"));
		System.out.println(railRoadService.getTotalDistance("A-D"));
		System.out.println(railRoadService.getTotalDistance("A-D-C"));
		System.out.println(railRoadService.getTotalDistance("A-E-B-C-D"));
		System.out.println(railRoadService.getTotalDistance("A-E-D"));
		System.out.println(railRoadService.getNumberOfRoutesMaxNumStops('C', 'C',3));
		System.out.println(railRoadService.getNumberOfRoutesExactNumStops('A', 'C',4));
		System.out.println(railRoadService.getShortestDistance('A', 'C'));
		System.out.println(railRoadService.getShortestDistance('B', 'B'));
		System.out.println(railRoadService.getShortestDistance('B', 'A'));
		System.out.println(railRoadService.getNumberOfRoutesDistanceLessThan('C', 'C', 30));
	}
}
