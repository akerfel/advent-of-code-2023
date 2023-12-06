import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Part1 {
    
    public static void main(String[] args) throws IOException {
        List<String> lines = getInputLines(args[0]);
        String[] sourcesStr = lines.get(0).split(":")[1].strip().split(" ");
        int[] sources = new int[sourcesStr.length];
        for (int i = 0; i < sourcesStr.length; i++) {
            sources[i] = Integer.parseInt(sourcesStr[i]);
        }

        int i = 1;

        while (i < lines.size() - 1) {
            i += 2;

            int[] newSources = new int[sources.length];
            for (int t = 0; t < sources.length; t++) {
                newSources[t] = sources[t];
            }
            while (i < lines.size() - 1 && !lines.get(i).equals("")) {
                String[] splitStr = lines.get(i).split(" ");
                int[] lineAsInts = Arrays.stream(splitStr)
                    .mapToInt(x -> Integer.parseInt(x))
                    .toArray();
                
                int startDest = lineAsInts[0];
                int startSource = lineAsInts[1];
                int range = lineAsInts[2];

                for (int j = 0; j < sources.length; j++) {
                    int source = sources[j];
                    int aboveStartSource = source - startSource;
                    if (source >= startSource && source < startSource + range) {
                        newSources[j] = startDest + aboveStartSource;
                    }
                }
                i++;
            }
            for (int t = 0; t < sources.length; t++) {
                sources[t] = newSources[t];
            }
        }
        for (int source : sources) {
            System.out.println(source);
        }
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
