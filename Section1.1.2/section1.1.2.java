/*
ID: whynick1
LANG: JAVA
PROG: ride
TASK: Write a program which reads in the name of the comet and the name 
      of the group and figures out whether the final number is just the 
      product of all the letters in the name, where "A" is 1 and "Z" is 26. 
      For instance, the group "USACO" would be 21 * 19 * 1 * 3 * 15 = 17955. 
      If the group's number mod 47 is the same as the comet's number mod 47, 
      then you need to tell the group to get ready!
*/

import java.io.*;
import java.util.*;

class ride
{
  public static void main (String [] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new FileReader("ride.in"));
    Scanner sc = new Scanner(br);
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    int unicode[] = new int[6];
    int multiply;
    int mod[] = new int[2];
    int cnt = 0;
    
    while(true)
    {
      String str = sc.nextLine();
      multiply = 1;
      
      for (int i = 0; i < str.length(); i++)
      {
        unicode[i] = str.charAt(i) - 'A' + 1;
        multiply *= unicode[i];
      }
      mod[cnt] = multiply % 47;
      cnt++;  
      if (sc.hasNextLine())
        continue;
      else
        break;
    }
    
    if (mod[0] == mod[1])
      pw.println("GO");
    else
      pw.println("STAY");
    pw.close();
  }
}