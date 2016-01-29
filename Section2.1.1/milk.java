/*
ID: stphung1
LANG: JAVA
TASK: milk
*/
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class milk {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("milk.in"));
        PrintWriter pw = new PrintWriter(new File("milk.out"));

        int targetAmount = sc.nextInt();
        int maxFarmers = sc.nextInt();

        List<Farmer> farmers = new ArrayList<Farmer>();
        for(int i=0; i<maxFarmers; i++) {
            farmers.add(new Farmer(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(farmers, new Comparator<Farmer>() {
            @Override
            public int compare(Farmer arg0, Farmer arg1) {
                return arg0.getPrice() - arg1.getPrice();
            }
        });

        int amount = 0;
        int price = 0;
        for(Farmer f : farmers) {
            if (f.getAmount() + amount >= targetAmount) {
                int diff = (targetAmount - amount);
                price += diff*f.getPrice();
                amount += diff;
                break;
            } else {
                amount += f.getAmount();
                price += f.getPrice()*f.getAmount();
            }
        }
        pw.println(price);

        pw.close();
    }

    private static class Farmer {
        private final int amount;
        private final int price;

        public Farmer(int price, int amount) {
            this.amount = amount;
            this.price = price;
        }

        public int getAmount() {
            return this.amount;
        }

        public int getPrice() {
            return this.price;
        }

        public String toString() {
            return price + "";
        }
    }
}