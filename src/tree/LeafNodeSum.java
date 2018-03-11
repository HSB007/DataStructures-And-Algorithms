package tree;

/**
 * 
 * @author Hemant Singh Bisht
 *
 */


public class LeafNodeSum {
	Node root;
	
	static class Node
	{
		Integer value;
		Node left, right;
		
		Node(Integer value)
		{
			this.value = value;
			left = right = null;
		}
		
		@Override
		public String toString()
		{
			return String.valueOf(value);
		}
	}
	
	public int leafNodeSum(Node head)
	{	int sum=0;
		if(head!=null){		
			if(head.left == null && head.right == null)
				sum +=head.value;
			else{
				sum += leafNodeSum(head.left);
				sum+=leafNodeSum(head.right);
			}
		}
		return sum;
	}
    
	public static void main(String[] args) {
		
		LeafNodeSum binaryTree = new LeafNodeSum();
		binaryTree.root= new Node(5);
		binaryTree.root.left= new Node(2);
		binaryTree.root.right= new Node(8); 
		binaryTree.root.right.left= new Node(1); // Leaf
		binaryTree.root.left.left= new Node(9); // Leaf
		binaryTree.root.left.right= new Node(4);
		binaryTree.root.left.right.left= new Node(3); // Leaf
	    System.out.println("Leaf Node Sum");
	    System.out.print(binaryTree.leafNodeSum(binaryTree.root));
	}
}
