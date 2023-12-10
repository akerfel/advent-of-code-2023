import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part1 {
    public static void main(String[] args) throws IOException {
        List<String> lines = getInput(args[0]);

        String[] timesString = lines.get(0).split(":")[1].strip().split("\\s+");
        int[] times = Arrays.stream(timesString).mapToInt(Integer::parseInt).toArray();

        String[] distancesString = lines.get(1).split(":")[1].strip().split("\\s+");
        int[] distances = Arrays.stream(distancesString).mapToInt(Integer::parseInt).toArray();

        int result = 1; 
        for (int i = 0; i < times.length; i++) {
            int raceTime = times[i];
            int goalDist = distances[i];

            int waysToWin = 0;
            for (int heldTime = 1; heldTime < raceTime; heldTime++) {
                int speed = heldTime;
                int moveTime = raceTime - heldTime;
                if (speed * moveTime > goalDist) {
                    waysToWin++;
                }
            }
            result *= waysToWin;
        }
        System.out.println(result);
    }

    

    public static List<String> getInput(String fileName) throws IOException {
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
