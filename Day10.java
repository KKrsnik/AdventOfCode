import java.util.Scanner;

public class Day10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
// 10.1
//        String[] vhod = sc.nextLine().split(",");
//        int[] dolzine = new int[vhod.length];
//        for (int i = 0; i < vhod.length; i++) {
//            dolzine[i] = Integer.parseInt(vhod[i]);
//        }
//        int[] list = new int[256];
//        for (int i = 0; i < list.length; i++) {
//            list[i] = i;
//        }
//        int pos = 0;
//        int skip = 0;
//
//        for (int aDolzine1 : dolzine) {
//            int[] subList = new int[aDolzine1];
//            for (int j = 0; j < subList.length; j++) {
//                subList[j] = list[(pos + j) % list.length];
//            }
//
//            for (int j = 0; j < subList.length / 2; j++) {
//                int temp = subList[j];
//                subList[j] = subList[subList.length - j - 1];
//                subList[subList.length - j - 1] = temp;
//            }
//
//            for (int j = 0; j < subList.length; j++) {
//                list[(j + pos) % list.length] = subList[j];
//            }
//            pos += aDolzine1 + skip;
//            skip++;
//        }
//
//        System.out.println(list[0] * list[1]);

//10.2
        String vhod = sc.nextLine();
        int[] dolzine = new int[vhod.length() + 5];
        for (int i = 0; i < dolzine.length - 5; i++) {
            dolzine[i] = (int) vhod.charAt(i);
        }
        dolzine[dolzine.length - 5] = 17;
        dolzine[dolzine.length - 4] = 31;
        dolzine[dolzine.length - 3] = 73;
        dolzine[dolzine.length - 2] = 47;
        dolzine[dolzine.length - 1] = 23;

        int[] list = new int[256];
        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }

        int pos = 0;
        int skip = 0;

        for (int k = 0; k < 64; k++) {
            for (int aDolzine : dolzine) {
                int[] subList = new int[aDolzine];
                for (int j = 0; j < subList.length; j++) {
                    subList[j] = list[(pos + j) % list.length];
                }

                for (int j = 0; j < subList.length / 2; j++) {
                    int temp = subList[j];
                    subList[j] = subList[subList.length - j - 1];
                    subList[subList.length - j - 1] = temp;
                }

                for (int j = 0; j < subList.length; j++) {
                    list[(j + pos) % list.length] = subList[j];
                }
                pos += aDolzine + skip;
                skip++;
            }
        }

        int[] xor = new int[16];
        int pos2 = 0;
        for (int i = 0; i < xor.length; i++) {
            for (int j = 0; j < xor.length; j++) {
                xor[i] = xor[i] ^ list[pos2 + j];
            }
            pos2 += 16;
            System.out.print(String.format("%02x", xor[i]));
        }


    }
}
