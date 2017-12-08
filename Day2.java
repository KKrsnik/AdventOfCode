import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum1 = 0;
        int sum2 = 0;
        while (sc.hasNext()) {
            String vrstica = sc.nextLine();

            String[] crke = vrstica.split("\\s+");
//1.2
            for (int i = 0; i < crke.length; i++) {
                int prva = Integer.parseInt(crke[i]);
                for (int j = 0; j < crke.length; j++) {
                    if (i != j) {
                        int druga = Integer.parseInt(crke[j]);

                        if (prva % druga == 0) {
                            sum2 += prva / druga;
                        }
                    }
                }
            }


//1.1
            int max, min;
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for (String aCrke : crke) {
                int stevilka = Integer.parseInt(aCrke);
                if (stevilka > max) {
                    max = stevilka;
                }
                if (stevilka < min) {
                    min = stevilka;
                }
            }
            sum1 += max - min;
        }
        System.out.println("Answer 1: " + sum1);
        System.out.println("Answer 2: " + sum2);

    }
}
