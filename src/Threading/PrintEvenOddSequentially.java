package Threading;

/**
 * @author : Hemant Singh Bisht
 * Description : Create two Threads, one thread will print Odd number and other thread will print Even number
 *               output should print numbers in a sequential manner : 1 2 3 4 5 6 7 8 9 10 
 **/
class Pool
{
	int n;
	boolean flag = true;
	
	synchronized void printEven(int even)
	{
	    if(!flag)
	    {
		    try
		    {
		        wait();
		    }
		    catch(InterruptedException e)
		    {
		        System.out.println("InterruptedException");
		    }
	    }
	    System.out.println("Odd: " + even);
	    flag = false;
	    notify();
	}
	
	synchronized void printOdd(int odd)
	{
	    if(flag)
	    {
		    try
		    {
		        wait();
		    }
		    catch(InterruptedException e)
		    {
		        System.out.println("InterruptedException");
		    }
	    }
	    System.out.println("Even: " + odd);
	    flag = true;
	    notify();
	}
}

class EvenThread implements Runnable
{
	Pool poolObj;

	EvenThread(Pool poolObj)
	{
	    this.poolObj = poolObj;
	    new Thread(this).start();
	}
	
	public void run()
	{
	    for(int counter=1;counter<=10;counter=counter+2)
	        poolObj.printEven(counter);
	}
}

class OddThread implements Runnable
{
	Pool poolObj;

	OddThread(Pool poolObj)
	{
	    this.poolObj = poolObj;
	    new Thread(this).start();
	}
	public void run()
	{
		 for(int counter=2;counter<=10;counter=counter+2)
		        poolObj.printOdd(counter);
	}
}

public class PrintEvenOddSequentially
{
	public static void main(String args[])
	{
	    Pool poolObj = new Pool();
	    new EvenThread(poolObj);
	    new OddThread(poolObj);
	}
}