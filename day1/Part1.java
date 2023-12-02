import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part1 {
    public static void main(String[] args) throws IOException {
        List<String> lines = getInputLines(args[0]);

        int sum = 0;
        for (String line : lines) {
            System.out.println(getCalibrationValue(line));
            sum += getCalibrationValue(line);
        }
        System.out.println(sum);
    }

    static int getCalibrationValue(String line) {
        char digit1 = getFirstDigit(line);
        char digit2 = getSecondDigit(line);
        String calibrationString = String.valueOf(digit1) + String.valueOf(digit2);
        return Integer.parseInt(calibrationString);
    }

     private static char getFirstDigit(String line) {
        for (char c : line.toCharArray()) {
            if (Character.isDigit(c)) {
                return c;
            }
        }
        return '0';
     }

     private static char getSecondDigit(String line) {
        for (int i = line.length() - 1; i >= 0; i--) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                return c;
            }
        }
        return '0';
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