import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Part2 {
    public static void main(String[] args) throws IOException {
        List<String> lines = getInputLines(args[0]);

        int sum = 0;
        for (String line : lines) {
            sum += getPowerOfSet(line);
        }
        System.out.println(sum);
    }

    public static int getPowerOfSet(String line) {
        String[] rounds = line.split(":")[1].split(";");
        int maxRed = 0;
        int maxGreen = 0;
        int maxBlue = 0;

        for (String round : rounds) {
            int redCount = getCountOfColor(round, "red");
            int greenCount = getCountOfColor(round, "green");
            int blueCount = getCountOfColor(round, "blue");
            
            maxRed = Math.max(maxRed, redCount);
            maxGreen = Math.max(maxGreen, greenCount);
            maxBlue = Math.max(maxBlue, blueCount);
        }

        return maxRed * maxGreen * maxBlue;
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