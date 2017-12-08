import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] in = input.split("");
        int sum1 = 0;
        int sum2 = 0;

// 1.2
        for (int i = 0; i < in.length; i++) {
            int curr = Integer.parseInt(in[i]);
            int next = Integer.parseInt(in[(i + in.length / 2) % in.length]);
            if (curr == next) {
                sum2 += next;
            }
        }
//1.1
        for (int i = 0; i < in.length - 1; i++) {
            int curr = Integer.parseInt(in[i]);
            int next = Integer.parseInt(in[i + 1]);
            if (curr == next) {
                sum1 += next;
            }
        }
        int first = Integer.parseInt(in[0]);
        int last = Integer.parseInt(in[in.length - 1]);
        if (first == last) {
            sum1 += last;
        }
        System.out.println("Answer 1: " + sum1);
        System.out.println("Answer 2: " + sum2);
    }
}
