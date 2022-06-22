package DynamicTree;

public class ObjectTree {	
	private Node root;
	private String separator;
	
	public ObjectTree() { this("\\."); }
	
	public ObjectTree(String separator) {
		this.separator = separator;
		this.root = new Node("root");
	}
	
	public void push(String path, Object data) throws Exception {
		String[] nodes = path.split(separator);	
		String newNodeName = nodes[nodes.length - 1];
		if(newNodeName.isBlank()) throw new Exception("Name could not be empty");
		
		Node parent, current = root;
		
		for(String node: nodes) {
			String name = node.trim();
			
			if(name.isBlank()) throw new Exception("Name could not be blank");
			
			parent = current;
			current = (Node)current.getChild(name);
			
			if(current == null) {
				current = new Node(name);
				parent.addChild(current);
				System.out.println("Created new node named " + name);
			}
			
			if(current.getName().equals(newNodeName)) {
				current.setData(data);
				System.out.println("Node added");
			}
		}
	}
	
	public Node get(String path) throws Exception {
		String[] nodes = path.split(separator);	
		String newNodeName = nodes[nodes.length - 1];
		if(newNodeName.isBlank()) throw new Exception("Name could not be empty");
		
		Node current = root;
		
		for(String node: nodes) {
			String name = node.trim();
			
			if(name.isBlank()) throw new Exception("Name could not be blank");
			
			current = (Node)current.getChild(name);
			
			if(current == null) {
				throw new Exception("Could not get node with the name " + name);
			}
			
			if(current.getName().equals(newNodeName)) {
				return current;
			}
		}
		
		return null;
	}
}
