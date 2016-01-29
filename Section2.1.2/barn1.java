
/*
ID: whynick1
LANG: JAVA
PROG: barn1
TASK: Write a program that reads two numbers (expressed in base 10):
    N (1 <= N <= 15)
    S (0 < S < 10000)
    and then finds and prints (in base 10) the first N numbers strictly greater than S
    that are palindromic when written in two or more number bases (2 <= base <= 10).
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


class barn1
{
    public static void main(String args[]) 
    {
        try{
            BufferedReader br = new BufferedReader(new FileReader("barn1.in"));
            Scanner sc = new Scanner(br);
            BufferedWriter bw = new BufferedWriter(new FileWriter("barn1.out"));
            PrintWriter pw = new PrintWriter(bw);
            //start read input file
            int boardForSale = sc.nextInt();
            int totalNumOfStalls = sc.nextInt();
            int occupiedStalls = sc.nextInt();
            
            List<BoardCover> lst = new ArrayList<BoardCover>();
            //read all occupied stalls number into a BoardCover list
            for (int i = 0; i < occupiedStalls; i++)
            {
                BoardCover bc = new BoardCover(sc.nextInt());
                lst.add(bc);
            }
            
            //sort the List<BoardCover>
            Collections.sort(lst, new Comparator<BoardCover>() {
                @Override
                public int compare(BoardCover bc1, BoardCover bc2)
                {
                    return bc1.getStallNum() - bc2.getStallNum();
                }
            });
            
            //always, currentBoardLength >= currentBoardNum
            int currentBoardNum = lst.size();
            int currentBoardLength = currentBoardNum;
            //if within BoardForSale limit
            if (currentBoardNum <= boardForSale)
            {
                pw.println(currentBoardLength);
            }
            //currentBoard number exceed BoardForSale number
            else
            {
                //j means combine two BoardCovers with gap j
                for (int j = 1; j < 999; j++)
                {
                    System.out.println("////////////////////////\nNow is gap: " + j);
                    //k means start combination from BoardCover k
                    for (int k = 0; k < lst.size() - 1; k++)
                    {
                        int currentStallNum = lst.get(k).getStallNum();
                        int nextStallNum = lst.get(k + 1).getStallNum();
                        //combine 
                        if (lst.get(k).isCombined() == true)
                            continue;
                        if ( nextStallNum - currentStallNum <= j)
                        {
                            System.out.println("currentStall's LastNum: " + currentStallNum + " nextStall's FirstNum: " + nextStallNum);
                            lst.get(k).setCombined();
                            System.out.print("gap: " + j + " BoardCover: " + k + " currentBoard + " + (j - 1) + " = ");
                            currentBoardLength += (j - 1); 
                            System.out.println(currentBoardLength);
                            if (--currentBoardNum <= boardForSale)
                                break;
                            System.out.println("Not yet: currenBoardNum = " + currentBoardNum);
                        }
                    }
                    if (currentBoardNum <= boardForSale)
                        break;
                }
                //after for loop the currentBoardLength is already given
                pw.println(currentBoardLength);
                System.out.println("Output currentBoardLength: " + currentBoardLength);
            }
            sc.close();
            pw.close();
            
        } catch (IOException e) {
            System.out.println (e);
            System.out.println ("Could not find file \"barn1.in\"");
        }
    }
    
    public static class BoardCover
    {
        private int stallNum;
        private boolean combine = false;
        BoardCover(int num)
        {
            stallNum = num;
        }
        public void setCombined()
        {
            combine = true;
        }
        public int getStallNum()
        {
            return stallNum;
        }
        public boolean isCombined()
        {
            return combine;
        }
    }
    
}












