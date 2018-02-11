package array;


/**
 * @author Hemant Singh Bisht
 * Description: Form a sequence of numbers in ascending and descending order based on provided sequence of M and N char only.
 *              M represents Descending order and N represents Ascending order. Maximum input length of
 *              8 char will be given. output digit can be 1-9, all unique.
 * Input  :  MMM
 * Output : 4321
 * 
 * Input  :  NMMN 
 * Output : 14325           
 */

public class IncDecSequence {

	public static int calculateSequence(String pattern)
	{
	      int curr_max = 0;
	      int last_entry = 0;
	    
	        int j;
	        StringBuilder result=new StringBuilder();
	        for (int i=0; i<pattern.length(); i++)
	        {
	            int noOfNextD = 0;
	            switch(pattern.charAt(i))
	            {
	            case 'N':              
	                j = i+1;
	                while ( j < pattern.length()&&pattern.charAt(j)== 'M'){
	                    noOfNextD++;
	                    j++;
	                }
	                  
	                if (i==0)
	                {
	                    curr_max = noOfNextD + 2;
	                    result.append(++last_entry);
	                    result.append(curr_max);
	                    last_entry = curr_max;
	                }
	                else
	                {
	                    curr_max = curr_max + noOfNextD + 1;
	                    last_entry = curr_max;
	                    result.append(last_entry);
	                }
	    
	                for (int k=0; k<noOfNextD; k++)
	                {
	                    result.append(--last_entry);
	                    i++;
	                }
	                break;
	    
	            case 'M':
	                if (i == 0)
	                {
	                    j = i+1;
	                    while (j < pattern.length() && pattern.charAt(j) == 'M')
	                    {
	                        noOfNextD++;
	                        j++;
	                    }
	                    curr_max = noOfNextD + 2;
	    
	                    result.append(curr_max+""+ (curr_max - 1));
	    
	                    last_entry = curr_max - 1;
	                }
	                else
	                {
	                    result.append(last_entry - 1);
	                    last_entry--;
	                }
	                break;
	            }
	        }
	        return Integer.parseInt(result.toString());
	    }
	
	public static void main(String[] args) {
		String pattern = "NMMN";
		System.out.println(calculateSequence(pattern));
	}

}
