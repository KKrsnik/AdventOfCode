import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
//3.1
        int n = 0;
        int pot = 0;
        for (int i = 1; i * i <= input; i += 2) {
            n = i;
            pot++;
        }
        if (input != n * n) {
            n += 2;
        } else {
            pot--;
        }
        int rob1 = n * n - (pot);
        int rob2 = rob1 - (n - 1);
        int rob3 = rob2 - (n - 1);
        int rob4 = rob3 - (n - 1);


        if (input >= rob1 - (pot - 1)) {
            pot += Math.abs(input - rob1);
        } else if (input >= rob2 - (pot - 1)) {
            pot += Math.abs(input - rob2);
        } else if (input >= rob3 - (pot - 1)) {
            pot += Math.abs(input - rob3);
        } else if (input >= rob4 - (pot - 1)) {
            pot += Math.abs(input - rob4);
        } else {
            System.out.println("ERROR1");
        }

        System.out.println("Distance: " + pot);

//3.2
        int[][] polje = new int[289][289];
        int zacetek = 289 / 2;
        int x = zacetek;
        int y = zacetek;
        int ori = 3;
        polje[y][x] = 1;
        int sum = 0;


        while (sum <= input) {

            switch (ori) {
                case 0:
                    if (polje[y + 1][x] == 0) {
                        y++;
                        sum = sum(polje, x, y);
                        polje[y][x] = sum;

                    } else {
                        ori = (4 + ori - 2) % 4;
                    }
                    break;
                case 1:
                    if (polje[y][x - 1] == 0) {
                        x--;
                        sum = sum(polje, x, y);
                        polje[y][x] = sum;

                    } else {
                        ori = (4 + ori - 2) % 4;
                    }
                    break;
                case 2:
                    if (polje[y - 1][x] == 0) {
                        y--;
                        sum = sum(polje, x, y);
                        polje[y][x] = sum;

                    } else {
                        ori = (4 + ori - 2) % 4;
                    }
                    break;
                case 3:
                    if (polje[y][x + 1] == 0) {
                        x++;
                        sum = sum(polje, x, y);
                        polje[y][x] = sum;

                    } else {
                        ori = (4 + ori - 2) % 4;
                    }
                    break;
                default:
                    System.out.println("Napaka: napacena ORI");
                    break;
            }

            ori = (4 + ori + 1) % 4;

        }
        System.out.println("First larger value: " + sum);


    }

    private static int sum(int[][] polje, int x, int y) {
        int sum = 0;

        sum += polje[y + 1][x];
        sum += polje[y + 1][x + 1];
        sum += polje[y][x + 1];
        sum += polje[y - 1][x + 1];
        sum += polje[y - 1][x];
        sum += polje[y - 1][x - 1];
        sum += polje[y][x - 1];
        sum += polje[y + 1][x - 1];

        return sum;
    }
}
