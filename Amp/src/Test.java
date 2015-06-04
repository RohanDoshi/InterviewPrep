import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;


public class Test {

	public static void main(String[] args) throws JSONException {
		String tree = "{\"Ann\": [\"Betty\", \"Clare\"], \"Betty\": [\"Donna\", \"Elizabeth\", \"Flora\"], \"Clare\": [\"Gloria\", \"Hazel\"]}";
		Gson gson = new Gson();
		Type mapType = new TypeToken<Map<String,List<String>>>() {}.getType();
		Map<String, List<String>> map = gson.fromJson(tree, mapType);
		Iterator<String> parents = map.keySet().iterator();
		Family root = null;
		while(parents.hasNext()) {
			String parent = parents.next();
			if(root == null) {
				root = new Family();
			}
			List<String> children = map.get(parent);
			for(String child : children) {
				root.addChild(parent, child);
			}
		}
		
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(tree);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<?> iterator = jsonObject.keys();
		while(iterator.hasNext()) {
			System.out.println("--->"+iterator.next());
		}
		
		JSONObject object = new JSONObject(tree);
		String[] keys = JSONObject.getNames(object);

		for (String key : keys)
		{
		    System.out.println("****"+key);
		}
		
		System.out.println(root.firstAncestor("Hazel", "Gloria"));
		System.out.println(root.firstAncestor("Hazel", "Clare"));
		System.out.println(root.firstAncestor("Hazel", "Flora"));
		System.out.println(root.firstAncestor("Hazel", "Betty"));
		System.out.println(root.firstAncestor("Hazel", "Ann"));
		System.out.println(root.firstAncestor("Hazel", "Hazel"));
		
		Map<Set<String>, Integer> map1 = new HashMap<>();
		
	}

}

class Family {
	
	private class Node {
		Node parent;
		String name;
		public Node(String name) {
			this.name = name;
		}
	}
	
	private Map<String, Node> map;
	public Family() {
		this.map = new HashMap<String,Node>();
	}
	public boolean addChild(String parent, String child) {
		Node parentNode = map.get(parent);
		Node childNode = map.get(child);
		if(parentNode == null) {
			parentNode = new Node(parent);
		}
		
		if(childNode == null) {
			childNode = new Node(child);
		}
		
		childNode.parent = parentNode;
		this.map.put(parent, parentNode);
		this.map.put(child, childNode);
		return true;
	}
	
	public String firstAncestor(String name1, String name2) {
		Node node1 = map.get(name1);
		Node node2 = map.get(name2);
		if(node1 == null || node2 == null)
			return null;
		
		Set<Node> set = new HashSet<>();
		while(node1 != null && node2 != null) {
			if(set.contains(node1)) {
				return node1.name;
			}
			set.add(node1);
			if(set.contains(node2)) {
				return node2.name;
			}
			set.add(node2);
			node1 = node1.parent;
			node2 = node2.parent;
		}
		
		while(node1 != null) {
			if(set.contains(node1)) {
				return node1.name;
			}
			set.add(node1);
			node1 = node1.parent;
		}
		
		while(node2 != null) {
			if(set.contains(node2)) {
				return node2.name;
			}
			set.add(node2);
			node2 = node2.parent;
		}
		
		return null;
		
	}
}


class FamilyTree {
	private List<FamilyTree> children;
	private String name;
	private FamilyTree parent;
	
	public FamilyTree(String name) {
		this.name = name;
		this.children = new ArrayList<>();
	}
	public void addChild(String parent, String child) {
		addChild(this, parent, child);
	}
	private boolean addChild(FamilyTree tree, String parent, String child) {
		if(tree.name.equals(parent)) {
			FamilyTree childTree = new FamilyTree(child);
			childTree.parent = tree;
			tree.children.add(childTree);
			return true;
		} else {
			List<FamilyTree> childrenTree = tree.children;
			for(FamilyTree childTree : childrenTree) {
				boolean addDone = addChild(childTree, parent, child);
				if(addDone)
					return true;
			}
		}
		return false;
	}
	public String findFirstAncestor(String name1, String name2) {
		return null;
	}
	
}
