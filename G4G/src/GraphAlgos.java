import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class GraphAlgos {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');
		graph.addVertex('F');
		graph.addVertex('G');
		graph.addVertex('S');
		graph.addVertex('T');
		
		graph.addEdge('A','C');
		graph.addEdge('B','S');
		graph.addEdge('B','D');
		graph.addEdge('C','D');
		graph.addEdge('C','E');
		graph.addEdge('D','F');
		graph.addEdge('D','T');
		graph.addEdge('D','E');
		graph.addEdge('E','G');
		graph.addEdge('E','T');
		graph.addEdge('G','T');
		graph.addEdge('G','E');
		graph.addEdge('T','F');
		graph.addEdge('S','A');
		graph.addEdge('S','B');
		//graph.addEdge('S','D');
		
		List<Character> list = graph.getVerticesAtDistance('S', 3);
		System.out.println(Arrays.toString(list.toArray()));
		
	}

}

class Graph {
	private class Vertex { 
		char name;
		List<Vertex> neighbors; 
		public Vertex(char name) {
			this.name = name;
			this.neighbors = new LinkedList<>();
		}
		
		public void addEdge(Vertex to) {
			this.neighbors.add(to);
		}
	}
	
	private Map<Character, Vertex> map;
	private List<Vertex> vertices;
	public Graph() {
		this.map = new HashMap<Character, Graph.Vertex>();
		this.vertices = new LinkedList<Vertex>();
	}
	
	public boolean addVertex(char name) {
		if(map.containsKey(name))
			return false;
		
		Vertex vertex = new Vertex(name);
		this.vertices.add(vertex);
		this.map.put(name, vertex);
		return true;
	}
	
	public boolean addEdge(char from, char to) {
		if(this.map.containsKey(from) && this.map.containsKey(to)) {
			this.map.get(from).addEdge(this.map.get(to));
			return true;
		}
		return false;
	}
	
	public List<Character> getVerticesAtDistance(char fromVertex, int distance) {
		if(!this.map.containsKey(fromVertex))
			return new ArrayList<>();
		
		List<Character> list = new LinkedList<>();
		if(distance == 0) {
			list.add(fromVertex);
			return list;
		}
		
		return getVertices(this.map.get(fromVertex), distance);
			
	}
	
	private List<Character> getVertices(Vertex root, int distance) {
		
		Queue<Vertex> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		Set<Vertex> visited = new HashSet<>();
		List<Character> list = new ArrayList<>();
		int currDistance = 0;
		while(queue.size() != 1) {
			Vertex vertex = queue.poll();
			if(vertex == null) {
				currDistance++;
				if(currDistance > distance)
					break;
				queue.add(null);
				continue;
			}
			
			if(visited.contains(vertex))
				continue;
			visited.add(vertex);
			
			if(currDistance == distance) {
				list.add(vertex.name);
				continue;
			}
			
			List<Vertex> neighbors = vertex.neighbors;
			for(Vertex neigh : neighbors) {
				queue.add(neigh);
			}
			
		}
		return list;
	}
	 
}