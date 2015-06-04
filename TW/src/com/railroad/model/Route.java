package com.railroad.model;

/*
 * 
 * @Date : 05/10/2015
 * @Author : Rohan Doshi
 * 
 */
public class Route {
	private Town fromTown;
	private Town toTown;
	private double distance;
	
	public Route(Town fromTown, Town toTown, double distance) {
		this.fromTown = fromTown;
		this.toTown = toTown;
		this.distance = distance;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
}
