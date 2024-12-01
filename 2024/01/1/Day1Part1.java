import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day1Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("1/input.txt");

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        try(Scanner sc = new Scanner(f)) {
            while(sc.hasNext()) {
                String line = sc.nextLine();
                String[] parts = line.split(" ");
                listA.add(Integer.parseInt(parts[0]));
                listB.add(Integer.parseInt(parts[3]));
            }
        }

        Collections.sort(listA);
        Collections.sort(listB);

        assert listA.size() == listB.size();

        int sum = 0;

        for(int i = 0; i < listA.size(); i++) {
            sum += Math.abs(listA.get(i) - listB.get(i));
        }

        System.out.println(sum);
    }
}