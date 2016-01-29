/*
ID: whynick1
LANG: JAVA
PROG: test
TASK: The simplest programming challenge is named 'test' and requires 
      you to read a pair of small integers from a single input line in
      the file 'test.in' and print their sum to the file 'test.out'.
*/
import java.io.*;
import java.util.*;

class test
{
  public static void main (String [] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new FileReader("test.in"));
    StringTokenizer st = new StringTokenizer(br.readLine());

    BufferedWriter bw = new BufferedWriter(new FileWriter("test.out"));
    PrintWriter pw = new PrintWriter(bw);

    int i1 = Integer.parseInt(st.nextToken());
    int i2 = Integer.parseInt(st.nextToken());
    pw.println(i1 + i2);
    pw.close();
  }
}















