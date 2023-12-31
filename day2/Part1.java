import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Part1 {
    public static void main(String[] args) throws IOException {
        List<String> lines = getInputLines(args[0]);

        int idSum = 0;
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (gameIsPossible(line)) {
                int gameId = i + 1;
                idSum += gameId;
            }
        }
        System.out.println(idSum);
    }

    public static boolean gameIsPossible(String line) {
        String[] rounds = line.split(":")[1].split(";");
        for (String round : rounds) {
            int redCount = getCountOfColor(round, "red");
            int greenCount = getCountOfColor(round, "green");
            int blueCount = getCountOfColor(round, "blue");
           
            if (redCount > 12 || greenCount > 13 || blueCount > 14)
                return false;
        }

        return true;
    }

    public static int getCountOfColor(String line, String color) {
        Pattern pattern = Pattern.compile("(\\d+) " + color);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
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