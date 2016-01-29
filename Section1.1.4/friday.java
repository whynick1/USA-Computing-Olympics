
/*
ID: whynick1
LANG: JAVA
PROG: friday
TASK:  write a program that will compute the frequency that the 13th of each month lands
 	   on Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, and Saturday over a given
 	   period of N years. The time period to test will be from January 1, 1900 to December 31, 
 	   1900+N-1 for a given number of years, N. N is positive and will not exceed 400.
*/

import java.io.*;
import java.util.*;

class friday
{
	public static void main (String [] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new FileReader("friday.in"));
	    Scanner sc = new Scanner(br);
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
	    int endYear = sc.nextInt(); 
	    int freq[] = new int[7];
	    int leapYearMonth[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    int nonLeapYearMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    
	    int countDay = -1;
	    
	    for (int year = 1900; year < (1900 + endYear); year++)
	    {
	    	//non leap, etc. 1700
//	    	System.out.println("year: " + year);
	    	if (isLeapYear(year))
	    	{
	    		for (int month = 0; month < 12; month++)
	    		{
	    			freq[(countDay + 13) % 7]++;
//	    			System.out.println("month:" + (month+1) + "zhou:" + ((countDay + 13) % 7 + 1));
		    		countDay = (countDay + leapYearMonth[month]);
	    		}
	    	}
	    	else
	    	{
	    		for (int month = 0; month < 12; month++)
	    		{
	    			freq[(countDay + 13) % 7]++;
//	    			System.out.println("month:" + (month+1) + "zhou:" + ((countDay + 13) % 7 + 1));
		    		countDay = (countDay + nonLeapYearMonth[month]);
	    		}
	    	}
	    }
	    
	    pw.print(freq[5] + " ");
	    pw.print(freq[6] + " ");
	    pw.print(freq[0] + " ");
	    pw.print(freq[1] + " ");
	    pw.print(freq[2] + " ");
	    pw.print(freq[3] + " ");
	    pw.println(freq[4]);
	    
	    sc.close();
	    pw.close();
	}
	
	public static Boolean isLeapYear(int year)
	{
		if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return year % 4 == 0;
        }
	}
}














