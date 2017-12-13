import java.util.HashMap;
import java.util.Scanner;

public class Day13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> input = new HashMap<>();
        int lenght = 0;
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(": ");
            lenght = Integer.parseInt(line[0]);
            input.put(lenght, Integer.parseInt(line[1]));
        }
        int location;
        int cost;
        int delay = -1;
        boolean cought;
        while (true) {
            delay++;
            cost = 0;
            location = -1;
            cought = false;
            for (int i = 0; i < lenght + 1; i++) {
                location++;
                if (input.get(location) != null) {
                    int modul = input.get(location) + (input.get(location) - 2);
                    int scanner = (i + delay) % modul;
                    if (scanner == 0) {
                        cost += input.get(location) * location;
                        cought = true;
                        if (delay != 0) {
                            break;
                        }
                    }
                }
            }
            if (delay == 0) {
                System.out.println("Answer 1: " + cost);
            }
            if (!cought) {
                break;
            }
        }

        System.out.println("Answer 2: " + delay);

    }
}
