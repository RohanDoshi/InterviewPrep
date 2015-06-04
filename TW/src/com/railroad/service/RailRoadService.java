package com.railroad.service;

/*
 * 
 * @Date : 05/10/2015
 * @Author : Rohan Doshi
 * 
 */
public interface RailRoadService {
	String RAIL_ROAD_DELIMITER = ",";
	String TOTAL_DISTANCE_DELIMITER = "-";
	boolean isRouteExist(char town1, char town2);
	String getTotalDistance(String towns);
	int getNumberOfRoutesExactNumStops(char town1, char town2, int numStops);
	int getNumberOfRoutesMaxNumStops(char town1, char town2, int numStops);
	double getShortestDistance(char town1, char town2);
	int getNumberOfRoutesDistanceLessThan(char town1, char town2, double distance);
}
