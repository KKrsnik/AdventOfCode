import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day8 {
    private static int izracunaj(String[] vrstica, HashMap<String, Integer> registri) {
        int vrednost = registri.get(vrstica[0]);
        switch (vrstica[1]) {
            case "inc":
                return vrednost + Integer.parseInt(vrstica[2]);
            case "dec":
                return vrednost - Integer.parseInt(vrstica[2]);
            default:
                System.out.println("Napaka: vrstica[1] ni 'inc' ali 'dec'");
                return 0;
        }
    }

    private static boolean primerjaj(String[] vrstica, HashMap<String, Integer> registri) {
        int vrednostReg;
        vrednostReg = registri.getOrDefault(vrstica[4], 0);
        int vrednost = Integer.parseInt(vrstica[6]);

        switch (vrstica[5]) {
            case "<":
                return vrednostReg < vrednost;
            case ">":
                return vrednostReg > vrednost;
            case "==":
                return vrednostReg == vrednost;
            case "<=":
                return vrednostReg <= vrednost;
            case ">=":
                return vrednostReg >= vrednost;
            case "!=":
                return vrednostReg != vrednost;
            default:
                System.out.println("Napaka: v primerjaj si pozabu dodat operand: " + vrstica[5]);
                return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> registri = new HashMap<>();
        int maxOverall = Integer.MIN_VALUE;
        while (sc.hasNext()) {
            String[] vrstica = sc.nextLine().split(" ");
            if (!registri.containsKey(vrstica[0])) {
                registri.put(vrstica[0], 0);
            }
            if (primerjaj(vrstica, registri)) {
                int vredost = izracunaj(vrstica, registri);
                if (vredost > maxOverall) {
                    maxOverall = vredost;
                }
                registri.replace(vrstica[0], vredost);
            }

        }
        Map.Entry<String, Integer> max = null;
        for (Map.Entry<String, Integer> entry : registri.entrySet()) {
            if (max == null || entry.getValue().compareTo(max.getValue()) > 0) {
                max = entry;
            }
        }

        if (max != null) {
            System.out.println("Max na koncu: " + max.getValue());
            System.out.println("Max na splosno: " + maxOverall);
        } else {
            System.out.println("Napaka: max == null");
        }

    }
}
