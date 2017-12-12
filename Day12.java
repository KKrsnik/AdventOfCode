import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day12 {
    private static ArrayList<Integer> connected(HashMap<Integer, int[]> input, int index) {
        ArrayList<Integer> connected = new ArrayList<>();
        connected.add(index);
        for (int i = 0; i < connected.size(); i++) {
            index = connected.get(i);
            for (int j = 0; j < input.get(index).length; j++) {
                if (!connected.contains(input.get(index)[j])) {
                    connected.add(input.get(index)[j]);
                }
            }
        }
        return connected;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, int[]> input = new HashMap<>(6);

        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(" ");
            int[] sons = new int[line.length - 2];
            for (int i = 2; i < line.length - 1; i++) {
                String[] temp = line[i].split(",");
                line[i] = temp[0];
            }
            for (int i = 0; i < sons.length; i++) {
                sons[i] = Integer.parseInt(line[i + 2]);
            }
            input.put(Integer.parseInt(line[0]), sons);
        }
        boolean add = true;
        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            for (ArrayList<Integer> group : groups) {
                if (group.contains(i)) {
                    add = false;
                }
            }
            if (add) {
                groups.add(connected(input, i));
            }
            add = true;
        }

        System.out.println("Answer 1: " + groups.get(0).size());
        System.out.println("Answer 2: " + groups.size());
    }
}
