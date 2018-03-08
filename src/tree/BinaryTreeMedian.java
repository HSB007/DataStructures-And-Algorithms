package tree;

/**
 * 
 * @author Hemant Singh Bisht
 *
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


public class BinaryTreeMedian {
	Node root;
	
	public static float findMedian(Node root){
        int count = countOfNodes(root);
        if(count == 1){
            return root.value;
        }
        
        if(count%2==1){
            return medianuptoK(root,count/2+1);
        }else{
            return (medianuptoK(root,count/2)+medianuptoK(root,count/2+1))/(float)2;
        }
    }
 
    public static int medianuptoK(Node root,int k){
        if(root==null){
        	return 0;
        }
        int count = countOfNodes(root.left);
        if(count+1==k){
            return root.value;
        }else if(count+1<k){
            return medianuptoK(root.right,k-count-1);
        }else{
            return medianuptoK(root.left,k);
        }
    }
    
 
    public static int countOfNodes(Node root){
        if(root==null) return 0;
        
        return countOfNodes(root.left)+1+countOfNodes(root.right);
    }
    /**
     * returns the median of the tree 
     * returns 0.0 if the tree is empty
     * @param args
     */
	public static void main(String[] args) {
		
		BinaryTreeMedian binaryTree = new BinaryTreeMedian();
		binaryTree.root= new Node(5);
		binaryTree.root.left= new Node(2);
		binaryTree.root.right= new Node(8);
		binaryTree.root.left.left= new Node(-1);
		binaryTree.root.left.right= new Node(4);
		binaryTree.root.left.right.left= new Node(3);
	    System.out.println("Median of the tree :");
	    System.out.print(BinaryTreeMedian.findMedian(binaryTree.root));
	}
}
