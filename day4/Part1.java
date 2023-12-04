import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Part1 {
    
    public static void main(String[] args) throws IOException {
        List<String> lines = getInputLines(args[0]);

        int sum = 0;
        for (String line : lines) {
            String[] winAndMine = line.split(":")[1].split("\\|");
            String[] winNumsStr = winAndMine[0].strip().split("\\s+");
            String[] myNumsStr = winAndMine[1].strip().split("\\s+");
            
            HashSet<Integer> winNums = new HashSet<>();
            for (String winNumStr : winNumsStr) {
                winNums.add(Integer.parseInt(winNumStr));
            }

            int cardPoints = 0;
            for (String myNumStr : myNumsStr) {
                int myNum = Integer.parseInt(myNumStr);
                if (winNums.contains(myNum)) {
                    if (cardPoints == 0) {
                        cardPoints = 1;
                    }
                    else {
                        cardPoints *= 2;
                    }
                }
            }

            sum += cardPoints;
        }
        System.out.println(sum);
    }

    public static List<String> getInputLines(String fileName) throws IOException {
        List<String> lines = new ArrayList<String>();
        BufferedReader bf = new BufferedReader(new FileReader(fileName));
        String newLine = bf.readLine();
        while (newLine != null) {
            lines.add(newLine);
            newLine = bf.readLine();
        }
        bf.close();
        return lines;
    }
}
