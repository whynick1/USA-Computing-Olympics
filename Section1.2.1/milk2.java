
/*
ID: whynick1
LANG: JAVA
PROG: milk2
TASK:  Your job is to write a program that will examine a list of beginning and 
	   ending times for N (1 <= N <= 5000) farmers milking N cows and compute (in seconds):
	   The longest time interval at least one cow was milked.
	   The longest time interval (after milking starts) during which no cows were being milked.
*/

import java.io.*;
import java.util.*;

class milk2
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader bf = new BufferedReader(new FileReader("milk2.in"));
		Scanner sc = new Scanner(bf);
		BufferedWriter bw = new BufferedWriter(new FileWriter("milk2.out"));
		PrintWriter pw = new PrintWriter(bw);
		
		int farmerNum = Integer.parseInt(sc.nextLine());
		int[] startTime = new int[farmerNum];
		int[] endTime = new int[farmerNum];
		int printAnswer[] = new int[2];
		
		//maxTimeCowIsMilkedStartEnd[0] = start time
		int[] maxTimeCowIsMilkedStartEnd = {0, 0};

		for (int i = 0; i < farmerNum; i++)
		{
			startTime[i] = Integer.parseInt(sc.next());
			endTime[i] = Integer.parseInt(sc.next());
			if (sc.hasNextLine())
				sc.nextLine();
		}
		//calculate the longest time at least one cow is milked
		printAnswer = returnMaxTimeCowIsMilked(startTime, endTime, maxTimeCowIsMilkedStartEnd);
		pw.println(printAnswer[0] + " " + printAnswer[1]);
		System.out.println("maxTimeCowIsMilked is: " + printAnswer[0]);
		System.out.println("maxTimeMilkGap is: " + printAnswer[1]);		
		sc.close();
		pw.close();
	}
	
	public static int[] returnMaxTimeCowIsMilked(int[] startTime, int[] endTime, int[] maxTimeStartEnd)
	{
		mergeSort(startTime, endTime, 0, (startTime.length - 1));
		//initiate the first working farmer start and end milking time
		maxTimeStartEnd[0] = startTime[0];
		maxTimeStartEnd[1] = endTime[0];
		
		//use a for loop to find maxTime milked with start time order
		//maxMilkTime[0] = maxMilkTime; maxMilkTime[1] = maxNonMilkGap
		int maxMilkTime[] = {0, 0};
		for (int i = 0; i < startTime.length; i++)
		{
			//start time earlier than the last end time -> continue milking
			if (startTime[i] <= maxTimeStartEnd[1])
			{
				if (maxTimeStartEnd[1] <= endTime[i])
				{
					maxTimeStartEnd[1] = endTime[i];
					if (maxMilkTime[0] < (maxTimeStartEnd[1] - maxTimeStartEnd[0]))
						maxMilkTime[0] = maxTimeStartEnd[1] - maxTimeStartEnd[0];
					System.out.println("maxTimeStartEnd[1] - maxTimeStartEnd[0]: " + maxTimeStartEnd[1] + " "
							+ maxTimeStartEnd[0]);	
				}
			}
			//start time later than the last end time -> resume milking
			else
			{
				//calculate the biggest interval of no milking
				if (maxMilkTime[1] < (startTime[i] - maxTimeStartEnd[1]))
					maxMilkTime[1] = (startTime[i] - maxTimeStartEnd[1]);
				maxTimeStartEnd[1] = endTime[i];
				maxTimeStartEnd[0] = startTime[i];
				if (maxMilkTime[0] < (maxTimeStartEnd[1] - maxTimeStartEnd[0]))
					maxMilkTime[0] = maxTimeStartEnd[1] - maxTimeStartEnd[0];
			}
			System.out.println("start time is: " + startTime[i]);
			System.out.println("currentMaxTimeCowIsMilked is: " + maxMilkTime[0]);	
		}
		return maxMilkTime;
	}
	
	public static void mergeSort(int[] starTime, int[] endTime, int left, int right)
	{
		if( left < right )
		{
			int center = (left + right) / 2;
			mergeSort(starTime, endTime, left, center);
			mergeSort(starTime, endTime, center + 1, right);
			merge(starTime, endTime, left, center + 1, right);
		}
	}
	
    private static void merge(int[] startTime, int[] endTime, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;
        int []tmp_startTime = new int[startTime.length];
        int []tmp_endTime = new int[startTime.length];

        while(left <= leftEnd && right <= rightEnd)
            if(startTime[left] <= startTime[right])
            {
            	tmp_startTime[k] = startTime[left];
            	tmp_endTime[k] = endTime[left];
            	k++;
            	left++;
            } 
            else
            {
            	tmp_startTime[k] = startTime[right];
            	tmp_endTime[k] = endTime[right];
            	k++;
            	right++;
            }
           
        while(left <= leftEnd)    // Copy rest of first half
        {
        	tmp_startTime[k] = startTime[left];
        	tmp_endTime[k] = endTime[left];
        	k++;
        	left++;
        }   

        while(right <= rightEnd)  // Copy rest of right half
        {
        	tmp_startTime[k] = startTime[right];
        	tmp_endTime[k] = endTime[right];
        	k++;
        	right++;
        }  
   
        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
        {
        	startTime[rightEnd] = tmp_startTime[rightEnd];
        	endTime[rightEnd] = tmp_endTime[rightEnd];
        }
    }
}










