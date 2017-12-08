import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max, min;
        int sum = 0;
        while (sc.hasNext()) {
            String vrstica = sc.nextLine();

            String[] crke = vrstica.split("\\s+");
//1.2
            for (int i = 0; i < crke.length; i++) {
                int prva = Integer.parseInt(crke[i]);
                for (int j = 0; j < crke.length; j++) {
                    if (i != j) {
                        int druga = Integer.parseInt(crke[j]);

                        if (prva%druga == 0) {
                            sum += prva/druga;
                        }
                    }
                }
            }



//1.1
//            max = 0;
//            min = Integer.MAX_VALUE;
//            for (int i = 0; i < crke.length; i++) {
//                int stevilka = Integer.parseInt(crke[i]);
//                if (stevilka > max) {
//                    max = stevilka;
//                }
//                if (stevilka < min) {
//                    min = stevilka;
//                }
//            }
//            sum += max-min;
        }
        System.out.println(sum);

    }
}
