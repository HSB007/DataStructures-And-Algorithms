package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 
 * @author Hemant Singh Bisht
 * Description : https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/the-football-fest-6/
 * 
 */
class Node
{
	private char step;
	private long id;
	
	Node(char step, long id)
	{
		this.step = step;
		this.id = id;
	}

	public char getStep() {
		return step;
	}

	public void setStep(char step) {
		this.step = step;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}

public class Thefootballfest6 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.valueOf(br.readLine()); 
        
        Stack<Node> passingSteps = new Stack<Node>();
        
        int i=1;
        while(i<=testCases)
        {
        	String noOfPassesStr = br.readLine();
        	String []noOfPasses = noOfPassesStr.split("\\s");
        	int noOfsteps = Integer.valueOf(noOfPasses[0]);
        	int id = Integer.valueOf(noOfPasses[1]);
        	
        	Node passNode = new Node('S', id);
        	passingSteps.add(passNode);
        	
        	int currentStep=1;
        	int backCount=0;
        	Node backupNode = null;
        	while(currentStep <= noOfsteps)
        	{
        		String noOfPassesStr1 = br.readLine();
        		String []stepsStr = noOfPassesStr1.split("\\s");
            	char step = stepsStr[0].charAt(0);
            	
            	if(step == 'B')
            	{
            		backCount++;
            		
            		if(backCount%2 != 0)
            			backupNode = passingSteps.pop();
            		else if(backCount%2 == 0)
            		{
            			passingSteps.add(backupNode);
            		}
            	}
            	else
            	{
	            	int id1= -1;
	            	if(step == 'P')
	            	{
	            		id1 = Integer.valueOf(stepsStr[1]);
	            		backCount=0;
	            	}
	            	Node passNode1 = new Node(step, id1);
	            	passingSteps.add(passNode1);
            	}
            	currentStep++;
        	}
        	
        	if(!passingSteps.empty())
        	{
        		Node stepNode = passingSteps.pop();
        		System.out.println("Player " + stepNode.getId());
        	}
        	i++;
        }
	}
}
