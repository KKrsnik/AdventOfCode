public class Day15 {
    public static void main(String[] args) {
        final long genA = 16807;
        final long genB = 48271;
        final long modul = 2147483647;

        long valueA = 116;
        long valueB = 299;
//15.1
//        final int numPairs = 40000000;
//        int counter = 0;
//        for (int i = 0; i < numPairs; i++) {
//
//            long resA = valueA * genA % modul;
//            valueA = resA;
//            long resB = valueB * genB % modul;
//            valueB = resB;
//
//            if (resA % 65536 == resB % 65536) {
//                counter++;
//            }
//        }
//
//
//        System.out.println(counter);
//15.2
        final int numPairs = 5000000;
        int counter = 0;
        for (int i = 0; i < numPairs;) {
            long resA = valueA * genA % modul;
            valueA = resA;
            if (resA % 4 == 0) {
                while (true) {
                    long resB = valueB * genB % modul;
                    valueB = resB;
                    if (resB % 8 == 0) {
                        if (resA % 65536 == resB % 65536) {
                            counter++;
                        }
                        i++;
                        break;
                    }
                }
            }
        }
        System.out.println(counter);
    }
}
