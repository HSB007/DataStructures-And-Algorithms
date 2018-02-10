package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreeVariablesAscending {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int number1 =Integer.parseInt(bf.readLine());
		int number2 =Integer.parseInt(bf.readLine());
		int number3 =Integer.parseInt(bf.readLine());
		
		if(number1 > number2){
			int temp = number1;
			number1 = number2;
			number2 = temp;
		}	
		if(number2 > number3){
			int temp = number2;
			number2 = number3;
			number3 = temp;
		}
		
		if(number1 > number2){
			int temp = number1;
			number1 = number2;
			number2 = temp;
		}
		
		System.out.println(number1 + "<" + number2 + "<" + number3);
	}
}
