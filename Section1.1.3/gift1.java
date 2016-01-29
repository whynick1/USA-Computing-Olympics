
/*
ID: whynick1
LANG: JAVA
PROG: gift1
TASK: Given a group of friends, no one of whom has a name 
	  longer than 14 characters, the money each person in 
	  the group spends on gifts, and a (sub)list of friends 
	  to whom each person gives gifts, determine how much more 
	  (or less) each person in the group gives than they receive.
*/

import java.io.*;
import java.util.*;

class gift1
{
	public static void main (String [] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new FileReader("gift1.in"));
	    Scanner sc = new Scanner(br);
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
	    int groupSize = Integer.parseInt(sc.nextLine());
	    String groupNames[] = new String[groupSize];
	    long [] groupGifts = new long[groupSize];
	
	    for (int i = 0; i < groupSize; i++)
	    {
	    	groupNames[i] = sc.nextLine();
	    	groupGifts[i] = 0;
	    }
	    
	    while (sc.hasNextLine())
	    {
	    	System.out.println("while");
	    	String giverName = sc.nextLine();
	    	System.out.println(" !!!!!!!!! " + giverName);
		    int giverNumber = 999;
		    long gifts = 0;
		    for (int i = 0; i < groupSize; i++)
		    {   
		    	if (groupNames[i].equals(giverName))
		    	{
		    		giverNumber = i;
		    		break;
		    	}
		    }
		    
		    int receiverNumber = 0; 
		    if (giverNumber != 999) //find the giver
		    {
		    	gifts = Integer.parseInt(sc.next());
		    	receiverNumber = Integer.parseInt(sc.next());
		    	//important!
		    	//if the gifts = 0, then inputfile will not provide receivers'name
		    	//without break, it make lead to .nextline() read error
		    	if (receiverNumber == 0)
		    	{
		    		sc.nextLine();
		    		continue;
		    	}
		    	gifts = (gifts/receiverNumber)*receiverNumber; 
		    }
		    String receiverNames[] = new String[receiverNumber];
		    //this line has been read, so should call nextline() to read next line to get receivers' name
		    sc.nextLine();
	    	for (int j = 0; j < receiverNumber; j++)
	    	{
	    		receiverNames[j] = sc.nextLine();
	    	}
	    	
	    	//now start to change each person's credit
	    	groupGifts[giverNumber] -= gifts;
	    	
	    	//k is the number of group people
	    	for (int k = 0; k < groupSize; k++)
	    	{
	    		//m is the number of gift receivers
	    		for (int m = 0; m < receiverNumber; m++)
	    		{
	    			if (groupNames[k].equals(receiverNames[m]))
	    			{
	    				groupGifts[k] += gifts/receiverNumber; 
	    			}
	    		}	
	    	}
	    }//end of while loop
	    
	    for (int n = 0; n < groupSize; n++)
	    {
	    	 pw.print(groupNames[n] + " ");
	    	 pw.println(groupGifts[n]);
	    }
	    sc.close();
	    pw.close();
	}
}














