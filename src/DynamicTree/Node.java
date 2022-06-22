package DynamicTree;

import java.util.HashMap;

public class Node {		
	public Object value;
	public Class<? extends Object> type;

	private String name;
	private HashMap<String, Node> children = new HashMap<>();
	
	public Node(String name) {
		this.name = name;
	}
	
	public void setData(Object data) {
		this.type = data.getClass();
		this.value = data;	
	}
	
	public void addChild(Node node) { children.put(node.getName(), node); }
	public Node getChild(String child) { return children.get(child); }
	
	public String getName() { return name; }
}