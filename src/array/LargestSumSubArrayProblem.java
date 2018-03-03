package array;

/**
 * 
 * @author Hemant Singh Bisht
 * Description : Find maximum sum of subarray in given array.
 * Alogithm : Kadane
 *
 */
public class LargestSumSubArrayProblem {

	public static int findLongestSumInSubArray(int inputArr[])
	{
		int maxSumFinal =Integer.MIN_VALUE;
		int maxSumTillNow =0;
		
		for(int index : inputArr)
		{
			maxSumTillNow += index;
			if(maxSumTillNow < 0)
				maxSumTillNow = 0;
			else if(maxSumFinal<maxSumTillNow)
				maxSumFinal = maxSumTillNow;
		}
		return maxSumFinal;
	}
	
	public static void main(String[] args) {
		
		int []input = {-2,-3,4,-1,-2,1,5,-3};
		int number = LargestSumSubArrayProblem.findLongestSumInSubArray(input);
		System.out.println("Largest Sum SubArray : " + number);
	}
}
//Output : Largest Sum SubArray : 7
