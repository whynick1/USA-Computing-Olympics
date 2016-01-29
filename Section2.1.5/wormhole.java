/*
ID: atttx121
LANG: JAVA
TASK: wormhole
*/

import java.io.*;
import java.util.*;

public class wormhole {

    static int N;
    static point[] wormholes;
    static int[] next_on_right;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("wormhole.in"));
        PrintWriter out = new PrintWriter(new FileWriter("wormhole.out"));

        N = in.nextInt();
        wormholes = new point[N + 1];
        next_on_right = new int[N + 1];
        wormholes[0] = new point(0, 0);
        Arrays.fill(next_on_right, 0);
        for (int i = 1; i <= N; i++) {
            in.nextLine();
            int x = in.nextInt();
            int y = in.nextInt();
            wormholes[i] = new point(x, y);
        }
        for (int i=1; i<=N; i++)  // set next_on_right[i]...
            for (int j=1; j<=N; j++)
                if (wormholes[j].x > wormholes[i].x
                        && wormholes[j].y == wormholes[i].y)  // j right of i...
                    if (next_on_right[i] == 0 ||
                            wormholes[j].x - wormholes[i].x
                                    < wormholes[next_on_right[i]].x - wormholes[i].x) // j is the first one
                        next_on_right[i] = j;
        out.println(pairing());
        exit(in, out);
    }

    private static int pairing() {
        int i, total = 0;
        for (i = 1; i <= N && wormholes[i].partner != 0; i++) {}

        if (i > N) {
            if (hasCycle()) return 1;
            else return 0;
        }

        for (int j = i + 1; j <= N ; j++) {
            if (wormholes[j].partner == 0) {
                wormholes[j].partner = i;
                wormholes[i].partner = j;
                total += pairing();
                wormholes[i].partner = 0;
                wormholes[j].partner = 0;
            }
        }
        return total;
    }

    private static boolean hasCycle() {
       for (int start = 1; start <= N; start++) {
           int pos = start;
           for (int count = 0; count < N; count++) {
               pos = next_on_right[wormholes[pos].partner];
           }
           if (pos != 0) {
               return true;
           }
       }
       return false;
    }

    private static void exit(Scanner in, Writer out) throws IOException {
        in.close();
        out.close();
        System.exit(0);
    }
}

class point {
    int x;
    int y;
    int partner = 0;

    public point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}