package tree;


/**
 * @author Hemant Singh Bisht
 */

public class PrintAllPathFromRootToLeaf {
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
	
	public int findAllPathRootToLeaf(Node head, int sum)
	{	
        if (head == null)
            return 0;
  
        sum += head.value;
  
        if (head.left == null && head.right == null){
            return sum;
        }
        
        int left = findAllPathRootToLeaf(head.left, sum);
        int right = findAllPathRootToLeaf(head.right, sum);
        
        return left + right;
	}
    
	public static void main(String[] args) {
		
		PrintAllPathFromRootToLeaf binaryTree = new PrintAllPathFromRootToLeaf();
		binaryTree.root= new Node(5);
		binaryTree.root.left= new Node(2);
		binaryTree.root.right= new Node(8); 
		binaryTree.root.right.left= new Node(1); // Leaf
		binaryTree.root.left.left= new Node(9); // Leaf
		binaryTree.root.left.right= new Node(4);
		binaryTree.root.left.right.left= new Node(3); // Leaf
	    System.out.println("Final Sum of all paths sum from Root to Leaf");
	    System.out.println(binaryTree.findAllPathRootToLeaf(binaryTree.root,0));
	}
}
