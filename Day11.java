import java.util.Scanner;

public class Day11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        int[] coords = {0, 0, 0};

        for (String anInput : input) {
            switch (anInput) {
                case "n":
                    coords[1]--;
                    break;
                case "nw":
                    coords[0]--;
                    break;
                case "ne":
                    coords[0]++;
                    coords[1]--;
                    break;
                case "s":
                    coords[1]++;
                    break;
                case "sw":
                    coords[0]--;
                    coords[1]++;
                    break;
                case "se":
                    coords[0]++;
                    break;
                default:
                    System.out.println("Error: wrong input");
                    break;
            }
        }

        coords[2] = -coords[0] - coords[1];

        int endMax = Math.max(Math.abs(coords[0]), Math.max(Math.abs(coords[1]), Math.abs(coords[2])));
        System.out.println("Answer 1: " + endMax);

        int[] coords2 = new int[3];
        int totalMax = Integer.MIN_VALUE;

        for (String anInput : input) {
            switch (anInput) {
                case "n":
                    coords2[1]--;
                    break;
                case "nw":
                    coords2[0]--;
                    break;
                case "ne":
                    coords2[0]++;
                    coords2[1]--;
                    break;
                case "s":
                    coords2[1]++;
                    break;
                case "sw":
                    coords2[0]--;
                    coords2[1]++;
                    break;
                case "se":
                    coords2[0]++;
                    break;
                default:
                    System.out.println("Error: wrong input");
                    break;
            }
            coords2[2] = -coords2[0] - coords2[1];
            int currMax = Math.max(Math.abs(coords2[0]), Math.max(Math.abs(coords2[1]), Math.abs(coords2[2])));
            totalMax = Math.max(currMax, totalMax);
        }

        System.out.println("Answer 2: " + totalMax);

    }
}
