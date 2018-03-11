package numbersProblem;

public class PrimeFactors {

	public static void main(String[] args) {
		Integer number =315;
		
		while(number%2 == 0)
		{
			    System.out.println(2);
				number = number/2; 
		}
		for(int i=3;i<=Math.sqrt(number);i+=2)
		{
			while (number%i == 0)
            {
                System.out.print(i + " ");
                number /= i;
            }
		}
		if (number > 2)
            System.out.print(number);
	}
}
