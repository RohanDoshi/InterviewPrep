package com.railroad.model;

/*
 * 
 * @Date : 05/10/2015
 * @Author : Rohan Doshi
 * 
 */
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.railroad.exceptions.InputStringRouteAlreadyExistsException;
import com.railroad.exceptions.NoSuchRouteExistsException;

public class Town {
 
	private String name;
	private Map<Town, Route> adjacentTowns;
	private static final String NO_SUCH_ROUTE = "NO SUCH ROUTE";
	
	public Town(String name) {
		this.name = name;
		this.adjacentTowns = new Hashtable<>();
	}

	public String getName() {
		return name;
	}
	
	public void addRoute(Town toTown, double distance) {
		if(adjacentTowns.containsKey(toTown)) {
			throw new InputStringRouteAlreadyExistsException("The route between "+this.name+" and "+toTown.getName()+" already exists");
		} else {
			adjacentTowns.put(toTown, new Route(this, toTown, distance));
		}
	}
	
	public boolean isRouteExist(Town t) {
		return adjacentTowns.containsKey(t);
	}
	
	public double getDistance(Town t) {
		if(isRouteExist(t)) {
			Route r = adjacentTowns.get(t);
			return r.getDistance();
		} else {
			throw new NoSuchRouteExistsException(NO_SUCH_ROUTE);
		}
	}
	
	public List<Town> getAllNeighboringTowns() {
		List<Town> list = new ArrayList<>();
		list.addAll(adjacentTowns.keySet());
		return list;
	}
	
	public Route getRoute(Town t) {
		return adjacentTowns.get(t);
	}
}
