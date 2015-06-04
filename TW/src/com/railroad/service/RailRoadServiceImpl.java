package com.railroad.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.railroad.exceptions.InputStringInvalidException;
import com.railroad.exceptions.InputStringSameTownException;
import com.railroad.exceptions.NoSuchRouteExistsException;
import com.railroad.exceptions.NoSuchTownExistsException;
import com.railroad.model.Town;

/*
 * 
 * @Date : 05/10/2015
 * @Author : Rohan Doshi
 * 
 */
public class RailRoadServiceImpl implements RailRoadService {
	
	/* The implementation of Graph is completely 
	 * abstracted from the user of this class */
	private class Graph {

		private Map<Character, Town> mapCharacterTown;
		
		public Graph(String railRoadString) {
			this.mapCharacterTown = new Hashtable<>();
			constructGraph(railRoadString);
		}
		
		private void constructGraph(String railRoadString) {
			if(railRoadString == null || railRoadString.isEmpty())
				return;
			
			try {
				String[] routes = railRoadString.split(RAIL_ROAD_DELIMITER);
				for(String route : routes) {
					route = route.trim().toUpperCase();
					char town1 = route.charAt(0);
					char town2 = route.charAt(1);
					if(town1 == town2)
						throw new InputStringSameTownException("Both from/to towns in a route are same !");
					
					double distance = Double.parseDouble(route.substring(2));
					addRoute(town1, town2, distance);
				}
			} catch(Exception e) {
				throw new InputStringInvalidException(e.getMessage(),e);
			}
		}
		
		private void addRoute(char town1, char town2, double distance) {
			if(!mapCharacterTown.containsKey(town1)) {
				mapCharacterTown.put(town1, new Town(Character.toString(town1)));
			}
			
			if(!mapCharacterTown.containsKey(town2)) {
				mapCharacterTown.put(town2, new Town(Character.toString(town2)));
			}
			
			mapCharacterTown.get(town1).addRoute(mapCharacterTown.get(town2), distance);
		}
		
		public boolean isRouteExists(char town1, char town2) {
			if(doTownsExists(town1, town2)) {
				Town t1 = mapCharacterTown.get(town1);
				Town t2 = mapCharacterTown.get(town2);
				return t1.isRouteExist(t2);
			} else {
				return false;
			}
		}
		
		public double getTotalDistance(char[] towns) {
			double totalDistance = 0;
			
			if(towns == null || towns.length == 0 || towns.length == 1)
				return totalDistance;
		
			char from = towns[0];
			for(int i=1; i<towns.length; i++) {
				totalDistance = totalDistance + getDistance(from, towns[i]);
				from = towns[i];
			}
			return totalDistance;
			
		}
		
		public double getDistance(char town1, char town2) {
			if(doTownsExists(town1, town2)) {
				Town t1 = mapCharacterTown.get(town1);
				Town t2 = mapCharacterTown.get(town2);
				return t1.getDistance(t2);
			} else {
				throw new NoSuchTownExistsException((mapCharacterTown.get(town1) == null ? town1 : town2)+" does not exist");
			}
		}
		
		public List<String> getAllPossibleRoutesLessThanDistance(char town1, char town2, double distance) {
			if(doTownsExists(town1, town2)) {
				Town t1 = mapCharacterTown.get(town1);
				Town t2 = mapCharacterTown.get(town2);
				List<String> list = new ArrayList<>();
				getRoutesDistance(t1, t2, "", list, 0, distance);
				return list;
			} else {
				throw new NoSuchTownExistsException((mapCharacterTown.get(town1) == null ? town1 : town2)+" does not exist");
			}
		}
		
		
		private void getRoutesDistance(Town sourceTown, Town destinationTown, String route, List<String> list, double currDistance, double maxDistance) {
			
			if(destinationTown == sourceTown && currDistance < maxDistance) {
				if(!route.isEmpty()) {
					list.add(route + destinationTown.getName());
				}
			}
			
			if(currDistance >= maxDistance) {
				return;
			}
			
			List<Town> routes = sourceTown.getAllNeighboringTowns();
			for(Town town : routes) {
				getRoutesDistance(town, destinationTown, route + sourceTown.getName(), list, currDistance + sourceTown.getDistance(town), maxDistance);
			}
		}
		
		
		public List<String> getAllPossibleRoutes(char town1, char town2, int numStops) {
			List<String> list = new ArrayList<>();
			if(doTownsExists(town1, town2)) {
				Town t1 = mapCharacterTown.get(town1);
				Town t2 = mapCharacterTown.get(town2);
				if(t1 == t2) {
					getRoutesSameTowns(t1, t2, "", list, numStops);
				} else  {
					getRoutes(t1, t2, "", list, 0, numStops);
				}
			} 
			return list;
		}
		
		private boolean doTownsExists(char town1, char town2) {
			if(mapCharacterTown.containsKey(town1) && mapCharacterTown.containsKey(town2)) {
				return true;
			} else {
				return false;
			}
		}
		
		private void getRoutesSameTowns(Town sourceTown, Town destinationTown, String route, List<String> list, int numStops) {
			List<Town> routes = sourceTown.getAllNeighboringTowns();
			for(Town town : routes) {
				getRoutes(town, destinationTown, route + sourceTown.getName(), list, 1, numStops);
			}
		}
		
		private void getRoutes(Town sourceTown, Town destinationTown, String route, List<String> list, int currNumStops, int numStops) {
			if(destinationTown == sourceTown && currNumStops == numStops) {
				if(!route.isEmpty()) {
					list.add(route + destinationTown.getName());
				}
				return;
			}
			
			if(currNumStops > numStops) {
				list = Collections.emptyList();
				return;
			}
			
			List<Town> routes = sourceTown.getAllNeighboringTowns();
			for(Town town : routes) {
				getRoutes(town, destinationTown, route + sourceTown.getName(), list, currNumStops+1, numStops);
			}
		}
		
		public double getShortestDistance(char town1, char town2) {
			if(doTownsExists(town1, town2)) {
				Town t1 = mapCharacterTown.get(town1);
				Town t2 = mapCharacterTown.get(town2);
				return shortestDistance(t1, t2);
			} else {
				throw new NoSuchTownExistsException((mapCharacterTown.get(town1) == null ? town1 : town2)+" does not exist");
			}
		}
		
		private double shortestDistanceSameTown(Town fromTown, Town toTown) {
			List<Town> neighboringTowns = fromTown.getAllNeighboringTowns();
			double minDistance = Double.MAX_VALUE;
			for(Town town : neighboringTowns) {
				double distance = fromTown.getDistance(town) + shortestDistance(town, toTown);
				if(distance < 0) {
					return Double.MIN_VALUE;
				} else {
					minDistance = Math.min(minDistance, distance);
				}
			}
			
			return minDistance;
		}
		
		private double shortestDistance(Town fromTown, Town toTown) {
			
			if(fromTown == toTown) {
				return shortestDistanceSameTown(fromTown, toTown);
			}
			
			Queue<Town> queue = new LinkedList<>();
			queue.add(fromTown);
			Set<Town> visited = new HashSet<>();
			Map<Town, Double> map = new HashMap<Town, Double>();
			map.put(fromTown, 0.0);
			while(queue.size() != 0) {
				Town temp = queue.poll();
				List<Town> neighboringTowns = temp.getAllNeighboringTowns();
				for(Town town : neighboringTowns) {
					if(!visited.contains(town)) {
						queue.add(town);
						if(!map.containsKey(town))
							map.put(town, map.get(temp) + temp.getDistance(town));
						else {
							Double dist = map.get(town);
							Double currentDistance = map.get(temp) + temp.getDistance(town);
							if(currentDistance < dist) {
								map.put(town, currentDistance);
							}
						}
					}
					visited.add(temp);
				}
			}
			
			if(map.containsKey(toTown)) {
				return map.get(toTown);
			} else {
				return Double.MIN_VALUE;
			}
		}
	}
	
	private Graph graph;
	public RailRoadServiceImpl(String railRoadString) {
		this.graph = new Graph(railRoadString);
	}
	
	@Override
	public boolean isRouteExist(char town1, char town2) {
		return graph.isRouteExists(town1, town2);
	}

	@Override
	public String getTotalDistance(String towns) {
		String[] townsArray = towns.split(TOTAL_DISTANCE_DELIMITER);
		char[] townNames = new char[townsArray.length];
		for(int i=0; i<townsArray.length; i++) {
			townNames[i] = townsArray[i].charAt(0);
		}
		try {
			return Double.toString(graph.getTotalDistance(townNames));
		} catch(NoSuchRouteExistsException e) {
			return e.getMessage();
		}
	}

	@Override
	public int getNumberOfRoutesExactNumStops(char town1, char town2,
			int numStops) {
		return graph.getAllPossibleRoutes(town1, town2, numStops).size();
	}

	@Override
	public int getNumberOfRoutesMaxNumStops(char town1, char town2, int numStops) {
		int totalNumRoutes = 0;
		for(int i=1; i<=numStops; i++) {
			totalNumRoutes += graph.getAllPossibleRoutes(town1, town2, i).size();
		}
		return totalNumRoutes;
	}

	@Override
	public double getShortestDistance(char town1, char town2) {
		Double distance = graph.getShortestDistance(town1, town2);
		if(distance == Double.MIN_VALUE)
			throw new NoSuchRouteExistsException("Infinite distance" );
		return distance;
	}

	@Override
	public int getNumberOfRoutesDistanceLessThan(char town1, char town2,
			double distance) {
		return graph.getAllPossibleRoutesLessThanDistance(town1, town2, distance).size();
	}

}
