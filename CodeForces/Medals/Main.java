import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int gold = (n + 11) / 12;

        int silver = ((n + 3) / 4) - gold;
        int bronze = ((n + 1) / 2) - gold - silver;

        if (gold < 0) {
            gold = 0;
        }
        if (silver < 0) {
            silver = 0;
        }
        if (bronze < 0) {
            gold = 0;
        }

        System.out.println(gold + " " + silver + " " + bronze);
    }
}