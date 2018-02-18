package tree;

/**
 * 
 * @author Hemant Singh Bisht
 * Description : Level order traversal of Binary Tree.
 */
class Node
{
	Integer value;
	Node left, right;
	
	Node(Integer value)
	{
		this.value = value;
		left = right = null;
	}
}

public class LevelOrderTraversal {

	Node root;
	
	public void printLevelOrder()
	{
		int treeHeight = heightOfTree(root);
		for(int level=1; level<=treeHeight; level++)
		{
			printLevels(root, level);
		}
	}
	
	public void printLevels(Node root, int level)
	{
		if(root == null)
			return;
		if(level == 1)
			System.out.print(root.value+ " ");
		else if(level > 1)
		{
			printLevels(root.left, level-1);
			printLevels(root.right, level-1);
		}
		
	}
	
	public int heightOfTree(Node root)
	{
		if(root == null)
			return 0;
		
		else
		{
			int leftHeight = heightOfTree(root.left);
			int rightHeight = heightOfTree(root.right);
			
			if(leftHeight > rightHeight)
				return (leftHeight+1);
			else
				return (rightHeight+1);
		}
	}
	
	public static void main(String[] args) {
		
		LevelOrderTraversal binaryTree = new LevelOrderTraversal();
		binaryTree.root= new Node(1);
		binaryTree.root.left= new Node(2);
		binaryTree.root.right= new Node(3);
		binaryTree.root.left.left= new Node(4);
		binaryTree.root.left.right= new Node(5);
	        
	    System.out.println("Level order traversal of binary tree :");
	    binaryTree.printLevelOrder();
		
	}
}
