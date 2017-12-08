import java.util.ArrayList;
import java.util.Arrays;

public class Day6 {
    public static void main(String[] args) {
        int[] vhod = new int[]{4, 10, 4, 1, 8, 4, 9, 14, 5, 1, 14, 15, 0, 15, 3, 5};
        ArrayList<int[]> stanja = new ArrayList<>();
        stanja.add(vhod);

        System.out.println(poisci(stanja));
    }

    private static int poisci(ArrayList<int[]> stanja) {
        int counter = 0;
        while (true) {
            int[] vhod = new int[stanja.get(0).length];
            System.arraycopy(stanja.get(stanja.size() - 1), 0, vhod, 0, vhod.length);
            int max = vhod[0];
            int maxInd = 0;
            for (int i = 1; i < vhod.length; i++) {
                if (max < vhod[i]) {
                    max = vhod[i];
                    maxInd = i;
                }
            }

            int razdeli = vhod[maxInd];
            vhod[maxInd] = 0;
            int stevec = maxInd;
            for (int i = 0; i < razdeli; i++) {
                stevec = (stevec + 1) % vhod.length;
                vhod[stevec]++;
            }
            counter++;
            for (int i = 0; i < stanja.size(); i++) {
                if (Arrays.equals(vhod, stanja.get(i))) {
//6.1
//                    return counter;
//6.2
                    return stanja.size() - i;
                }
            }
            stanja.add(vhod);
        }
    }
}
