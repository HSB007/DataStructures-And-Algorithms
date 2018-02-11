package array;

//@Author : Hemant Singh Bisht
//@Note : This program is only to find 1 non repetitive number in the Array. if you pass more than
//        one non repetitive number in the array it will fail.
//@TimeComplexity : O(n)

public class FindNonRepetitiveNumber {

	public static int findNonRepetitiveNum(int inputArr[])
	{
		int result =0;
		for(int index : inputArr)
			result ^= index;
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int []input = {4,2,1,2,4,6,7,1,7};
		int number = FindNonRepetitiveNumber.findNonRepetitiveNum(input);
		System.out.println("Non Repititive Number is : " + number);
	}

}
