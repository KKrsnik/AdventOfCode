import java.util.*;

public class Day4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

//4.1
//        while (sc.hasNext()) {
//            String vrstica = sc.nextLine();
//            String[] besede = vrstica.split(" ");
//            boolean pravilna = true;
//            for (int i = 0; i < besede.length; i++) {
//                for (int j = i + 1; j < besede.length; j++) {
//                    if (Objects.equals(besede[i], besede[j])) {
//                        pravilna = false;
//                        break;
//                    }
//
//                }
//            }
//            if (pravilna) {
//                sum++;
//            }
//        }
//
//4.2
        while (sc.hasNext()) {
            String vrstica = sc.nextLine();
            String[] besede = vrstica.split(" ");
            boolean pravilna = true;
            for (int i = 0; i < besede.length; i++) {
                for (int j = i + 1; j < besede.length; j++) {
                    if (Objects.equals(besede[i], besede[j])) {
                        pravilna = false;
                        break;
                    }
                    Map<Character, Integer> chars1 = new HashMap<>(Math.min(besede[i].length(), 26));
                    for (int k = 0; k < besede[i].length(); k++) {
                        char charAt = besede[i].charAt(k);

                        if (!chars1.containsKey(charAt)) {
                            chars1.put(charAt, 1);
                        } else {
                            chars1.put(charAt, chars1.get(charAt) + 1);
                        }
                    }
                    Map<Character, Integer> chars2 = new HashMap<>(Math.min(besede[i].length(), 26));
                    for (int k = 0; k < besede[j].length(); k++) {
                        char charAt = besede[j].charAt(k);

                        if (!chars2.containsKey(charAt)) {
                            chars2.put(charAt, 1);
                        } else {
                            chars2.put(charAt, chars2.get(charAt) + 1);
                        }
                    }
                    if (Objects.equals(chars1.keySet(), chars2.keySet())) {
                        pravilna = false;
                        break;
                    }


                }
            }
            if (pravilna) {
                sum++;
            }
        }

        System.out.println(sum);

    }
}
