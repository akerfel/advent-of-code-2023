import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part2 {
    public static void main(String[] args) throws IOException {
        List<String> lines = getInput(args[0]);

        String[] timesString = lines.get(0).split(":")[1].strip().split("\\s+");
        String raceTimeString = "";
        for (String str : timesString) {
            raceTimeString += str;
        }
        long raceTime = Long.parseLong(raceTimeString);


        String[] distancesString = lines.get(1).split(":")[1].strip().split("\\s+");
        String distString = "";
        for (String str : distancesString) {
            distString += str;
        }
        long goalDist = Long.parseLong(distString);

        // Done reading input
        long waysToWin = 0;
        for (long heldTime = 1; heldTime < raceTime; heldTime++) {
            long speed = heldTime;
            long moveTime = raceTime - heldTime;
            if (speed * moveTime > goalDist) {
                waysToWin++;
            }
        }
        System.out.println(waysToWin);
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
