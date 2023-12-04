import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Part2 {
    
    // ** Stream edition **
    public static void main(String[] args) throws IOException {
        List<String> lines = getInputLines(args[0]);
        int n = lines.size();
        int[] cardCopies = IntStream.range(0, n).map(i -> 1).toArray();

        for (int i = 0; i < n; i++) {
            String[] tmp = lines.get(i).split(":")[1].split("\\|");
            String[] winNumsStr = tmp[0].strip().split("\\s+");
            String[] myNumsStr = tmp[1].strip().split("\\s+");
            
            HashSet<Integer> winNums = Arrays.stream(winNumsStr)
                .map(x -> Integer.parseInt(x))
                .collect(Collectors.toCollection(HashSet::new));

            long matchingNumbers = Arrays.stream(myNumsStr)
                .map(x -> Integer.parseInt(x))
                .filter(x -> winNums.contains(x))
                .count();

            for (int k = i + 1; k < i + matchingNumbers + 1 && k < n; k++) {
                cardCopies[k] += cardCopies[i];
            }
        }
        int numCards = Arrays.stream(cardCopies).sum();
        System.out.println(numCards);
    }

    public static List<String> getInputLines(String fileName) throws IOException {
        List<String> lines = new ArrayList<String>();
        BufferedReader bf = new BufferedReader(new FileReader(fileName));
        String line = bf.readLine();
        while (line != null) {
            lines.add(line);
            line = bf.readLine();
        }
        bf.close();
        return lines;
    }
}
