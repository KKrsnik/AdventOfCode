import java.math.BigInteger;
import java.util.Scanner;

public class Day14 {
    private static String hash(String vhod) {
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
        String hex = "";
        for (int i = 0; i < xor.length; i++) {
            for (int j = 0; j < xor.length; j++) {
                xor[i] = xor[i] ^ list[pos2 + j];
            }
            pos2 += 16;
            hex = hex.concat(String.format("%02x", xor[i]));
        }
        return hex;
    }

    private static void findConnected(int x, int y, int[][] disc)
    {
        boolean canUp = (x - 1 >= 0);
        boolean canDown = (x + 1 < disc.length);
        boolean canRight = (y + 1 < disc[0].length);
        boolean canLeft = (y - 1 >= 0);

        int value = disc[x][y];

        disc[x][y] = 2;

        if (canUp && disc[x-1][y] == value) {
            findConnected(x-1,y,disc);
        }
        if (canDown && disc[x+1][y] == value) {
            findConnected(x+1,y,disc);
        }
        if (canLeft && disc[x][y-1] == value) {
            findConnected(x,y-1,disc);
        }
        if (canRight && disc[x][y+1] == value) {
            findConnected(x,y+1,disc);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int counter = 0;
        int[][] disc = new int[128][128];
        for (int i = 0; i < 128; i++) {
            String input2 = input.concat("-" + i);

            String bin = new BigInteger(hash(input2), 16).toString(2);
            bin = String.format("%128s", bin).replace(" ", "0");

            for (int j = 0; j < bin.length(); j++) {
                if (bin.charAt(j) == '1') {
                    counter++;
                    disc[i][j] = 1;
                }
            }
        }
        int groups = 0;
        for (int i = 0; i < disc.length; i++) {
            for (int j = 0; j < disc[i].length; j++) {
                switch (disc[i][j]) {
                    case 0:
                        break;
                    case 1:
                        findConnected(i, j, disc);
                        groups++;
                        break;
                    default:
                        break;

                }
            }
        }
        System.out.println("Answer 1: " + counter);
        System.out.println("Answer 2: " + groups);
    }
}
