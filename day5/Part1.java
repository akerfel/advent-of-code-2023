import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Part1 {
    
    public static void main(String[] args) throws IOException {
        List<String> lines = getInputLines(args[0]);
        String[] sourcesStr = lines.get(0).split(":")[1].strip().split(" ");
        long[] sources = new long[sourcesStr.length];
        for (int i = 0; i < sourcesStr.length; i++) {
            sources[i] = Long.parseLong(sourcesStr[i]);
        }

        int i = 1;
        while (i < lines.size() - 1) {
            i += 2;

            long[] newSources = new long[sources.length];
            for (int t = 0; t < sources.length; t++) {
                newSources[t] = sources[t];
            }
            while (i < lines.size() - 1 && !lines.get(i).equals("")) {
                String[] splitStr = lines.get(i).split(" ");
                long[] lineAsInts = Arrays.stream(splitStr)
                    .mapToLong(x -> Long.parseLong(x))
                    .toArray();
                
                long startDest = lineAsInts[0];
                long startSource = lineAsInts[1];
                long range = lineAsInts[2];

                for (int j = 0; j < sources.length; j++) {
                    long source = sources[j];
                    long aboveStartSource = source - startSource;
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
        long smallestSource = sources[0];
        for (long source : sources) {
            if (source < smallestSource) 
                smallestSource = source;
            System.out.println(source);
        }

        System.out.println("Answer: " + smallestSource);
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
