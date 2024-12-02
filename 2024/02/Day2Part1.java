import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day2Part1 {
    
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("input.txt");

        List<List<Integer>> reports = new ArrayList<>();

        try(Scanner sc = new Scanner(f)) {
            while(sc.hasNext()) {
                String line = sc.nextLine();
                reports.add(Arrays.stream(line.split(" ")).map(e -> Integer.parseInt(e)).toList());
            }
        }

        int saveReportCount = 0;
        for(List<Integer> report : reports) {
            if(isReportSave(report)) saveReportCount++;
        }

        System.out.println(saveReportCount);
    }


    private static boolean isReportSave(List<Integer> report) {
        int prev = report.getFirst();
        int prevStep = 0;

        for(int i = 1; i < report.size(); i++) {
            int current = report.get(i);
            int step = current - prev;
            
            // unsafe level difference
            if(Math.abs(step) > 3  || Math.abs(step) < 0) return false;
            // changing slope direction
            if(step > 0 && prevStep < 0 || step < 0 && prevStep > 0 || step == 0) return false;

            prev = current;
            prevStep = step;
        }
        return true;
    }
}
