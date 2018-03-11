package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Hemant Singh Bisht
 */

public class PrintFinalSumOfAllPathSumFromRootToLeaf {
	Node root;
	List<Integer> path = new LinkedList<Integer>();
	
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
	
	public void findAllPathRootToLeaf(Node head, int sum)
	{	
        if (head == null)
            return;
  
        path.add(head.value);
        sum += head.value;
  
        if (head.left == null && head.right == null){
        	System.out.println(path);
        }
        
        findAllPathRootToLeaf(head.left, sum);
        findAllPathRootToLeaf(head.right, sum);
        path.remove(path.size()-1);
	}
    
	public static void main(String[] args) {
		
		PrintFinalSumOfAllPathSumFromRootToLeaf binaryTree = new PrintFinalSumOfAllPathSumFromRootToLeaf();
		binaryTree.root= new Node(5);
		binaryTree.root.left= new Node(2);
		binaryTree.root.right= new Node(8); 
		binaryTree.root.right.left= new Node(1); // Leaf
		binaryTree.root.left.left= new Node(9); // Leaf
		binaryTree.root.left.right= new Node(4);
		binaryTree.root.left.right.left= new Node(3); // Leaf
	    System.out.println("Leaf Node Sum");
	    binaryTree.findAllPathRootToLeaf(binaryTree.root,0);
	}
}
