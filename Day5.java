import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vhod = new int[1056];

        for (int i = 0; i < vhod.length; i++) {
            vhod[i] = sc.nextInt();
        }
        int index = 0;
        int stevec = 0;
        int prevIndex;
        while (true) {
            try {
                prevIndex = index;
                index = index + vhod[index];
//5.2 dodatek samo if stavka
                if (vhod[prevIndex] > 2) {
                    vhod[prevIndex]--;
                } else {
//5.1 samo else
                    vhod[prevIndex]++;
                }
                stevec++;
            } catch (Exception e) {
                break;
            }
        }

        System.out.println(stevec);

    }
}
