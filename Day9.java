import java.util.Scanner;

public class Day9 {
    private static int index = 0;
    private static int stevec = 0;
    private static int groupScore = 0;
    private static int garbage = 0;

    private static int oklepaj(String vhod) {

        if (index >= vhod.length()) {
            return 0;
        }

        index = ostalo(vhod);

        while (vhod.charAt(index) == '!') {
            index += 2;
        }
        index = ostalo(vhod);
        if (vhod.charAt(index) == '<') {
            index++;
            while (vhod.charAt(index) != '>') {
                if (vhod.charAt(index) == '!') {
                    index += 2;
                    garbage--;
                } else {
                    index++;
                }
                garbage++;
            }
            index++;
        }
        index = ostalo(vhod);
        if (vhod.charAt(index) == '{') {
            index++;
            stevec++;
            return oklepaj(vhod);
        }
        index = ostalo(vhod);
        if (vhod.charAt(index) == '}') {
            index++;
            groupScore += stevec;
            stevec--;
            return oklepaj(vhod) + 1;
        }
        if (index < vhod.length()) {
            return oklepaj(vhod);
        }
        return 0;
    }

    private static int ostalo(String vhod) {
        while (vhod.charAt(index) != '!' && vhod.charAt(index) != '<' && vhod.charAt(index) != '{' && vhod.charAt(index) != '>' && vhod.charAt(index) != '}') {
            index++;
        }

        return index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String vhod = sc.nextLine();

        oklepaj(vhod);
        System.out.println("Answer 1: " + groupScore);
        System.out.println("Answer 2: " + garbage);


    }
}
