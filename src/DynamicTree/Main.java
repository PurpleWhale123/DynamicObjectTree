package DynamicTree;

public class Main {
	public static void main(String args[]) {
		ObjectTree tree = new ObjectTree("->");
		
		try {
			tree.push("user->profile->username", "Ilias");	
			tree.push("user->profile->age->num", 1235135);

			System.out.println(tree.get("user->profile->username").value);
			System.out.println(tree.get("user->profile->age").value);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
	}
}
