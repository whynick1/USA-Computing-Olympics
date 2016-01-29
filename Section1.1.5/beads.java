
/*
ID: whynick1
LANG: JAVA
PROG: beads
TASK:  Determine the point where the necklace should be broken so that the most 
       number of beads can be collected.
*/

import java.io.*;
import java.util.*;

class beads
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new FileReader("beads.in"));
        Scanner sc = new Scanner(bf);
        BufferedWriter bw = new BufferedWriter(new FileWriter("beads.out"));
        PrintWriter pw = new PrintWriter(bw);
        String neckLace;
        int neckLaceLength;
        int beadFront = 0;
        int beadEnd = 0;
        int beadMaximum = 0;
        char lastNonWhiteBeadColor = 'w';
        char lastBeadColor;
        int whiteBeadCount = 0;
        
        neckLaceLength = Integer.parseInt(sc.nextLine());
        neckLace = sc.next();
        lastBeadColor = neckLace.charAt(0);
        
        System.out.println("necklace length = " + neckLaceLength);
        System.out.println(neckLace);
        
        for (int i = 0; i < neckLaceLength; i++)
        {
            //found white bead
            if (neckLace.charAt(i) == 'w')
            {
                beadEnd++;
                beadMaximum = (beadMaximum < (beadEnd + beadFront)? (beadFront + beadEnd): beadMaximum);
                lastBeadColor = 'w';
                whiteBeadCount++;
            }
            //same color bead found
            //non white beads
            else if (lastBeadColor == neckLace.charAt(i))
            {
                beadEnd++;
                beadMaximum = (beadMaximum < (beadEnd + beadFront)? (beadFront + beadEnd): beadMaximum);
                lastNonWhiteBeadColor = neckLace.charAt(i);
            }
            //different color bead found, while last bead is white
            //non white bead
            else if (lastBeadColor == 'w')
            {
                //last colorful bead same color
                if (lastNonWhiteBeadColor == neckLace.charAt(i) || lastNonWhiteBeadColor == 'w')
                {
                    beadEnd++;
                    beadMaximum = (beadMaximum < (beadEnd + beadFront)? (beadFront + beadEnd): beadMaximum);
                    lastBeadColor = neckLace.charAt(i);
                    lastNonWhiteBeadColor = neckLace.charAt(i);
                    whiteBeadCount = 0;
                }
                //last colorful bead different color
                else
                {
                    beadFront = beadEnd - whiteBeadCount;
                    beadEnd = whiteBeadCount + 1;
                    lastBeadColor = neckLace.charAt(i);
                    lastNonWhiteBeadColor = neckLace.charAt(i);
                    whiteBeadCount = 0;
                }
            }
            //different color bead found, while last bead is not white
            //non white bead
            else
            {
                beadFront = beadEnd;
                beadEnd = 1;
                lastBeadColor = neckLace.charAt(i);
                lastNonWhiteBeadColor = lastBeadColor;
                whiteBeadCount = 0;
            }
            System.out.println("beadcolor is = " + neckLace.charAt(i));
            System.out.println("beadFront, beadEnd = " + beadFront + ", " + beadEnd);
            System.out.println("lastBeadColor = " + lastBeadColor + " lastNonWhiteBeadColor = " + lastNonWhiteBeadColor);
            System.out.println("");
        }
        
        for (int i = 0; i < neckLaceLength; i++)
        {
            //found white bead
            if (neckLace.charAt(i) == 'w')
            {
                beadEnd++;
                beadMaximum = (beadMaximum < (beadEnd + beadFront)? (beadFront + beadEnd): beadMaximum);
                lastBeadColor = 'w';
                whiteBeadCount++;
            }
            //same color bead found
            //non white beads
            else if (lastBeadColor == neckLace.charAt(i))
            {
                beadEnd++;
                beadMaximum = (beadMaximum < (beadEnd + beadFront)? (beadFront + beadEnd): beadMaximum);
                lastNonWhiteBeadColor = neckLace.charAt(i);
            }
            //different color bead found, while last bead is white
            //non white bead
            else if (lastBeadColor == 'w')
            {
                //last colorful bead same color
                if (lastNonWhiteBeadColor == neckLace.charAt(i))
                {
                    beadEnd++;
                    beadMaximum = (beadMaximum < (beadEnd + beadFront)? (beadFront + beadEnd): beadMaximum);
                    lastBeadColor = neckLace.charAt(i);
                    whiteBeadCount = 0;
                }
                //last colorful bead different color
                else
                {
                    beadFront = beadEnd - whiteBeadCount;
                    beadEnd = whiteBeadCount + 1;
                    lastBeadColor = neckLace.charAt(i);
                    lastNonWhiteBeadColor = neckLace.charAt(i);
                    whiteBeadCount = 0;
                }
            }
            //different color bead found, while last bead is not white
            //non white bead
            else
            {
                beadFront = beadEnd;
                beadEnd = 1;
                lastBeadColor = neckLace.charAt(i);
                lastNonWhiteBeadColor = lastBeadColor;
                whiteBeadCount = 0;
            }
            System.out.println("beadcolor is = " + neckLace.charAt(i));
            System.out.println("beadFront, beadEnd = " + beadFront + ", " + beadEnd);
            System.out.println("lastBeadColor = " + lastBeadColor + " lastNonWhiteBeadColor = " + lastNonWhiteBeadColor);
            System.out.println("");
        }
        
        System.out.println("beadMaximum = " + beadMaximum);
        
        if (beadMaximum <= neckLaceLength)
            pw.println(beadMaximum);
        else 
            pw.println(neckLaceLength);
        sc.close();
        pw.close();
    }
}














