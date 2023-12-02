import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public static void main(String[] args) throws IOException {
        List<String> lines = new ArrayList<String>();
        BufferedReader bf = new BufferedReader(new FileReader("input.txt"));
        String newLine = bf.readLine();
       
        while (newLine != null) {
            lines.add(newLine);
            newLine = bf.readLine();
        }
        bf.close();

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
        int n = line.length();
        for (int i = 0; i < n; i++) {
            char digit = getDigitAt(line, i);
            if (digit != '0')
                return digit;
        }
        return '0';
     }

     private static char getSecondDigit(String line) {
        int n = line.length();
        for (int i = n - 1; i >= 0; i--) {
            char digit = getDigitAt(line, i);
            if (digit != '0')
                return digit;
        }
        return '0';
     }

     private static char getDigitAt(String line, int i) {
        int n = line.length();

        // Check for actual digit
        char c = line.charAt(i);
        if (Character.isDigit(c)) {
            return c;
        }

        // Check for spelled out digit
        int digitLength = 3;
        if (i <= n - digitLength) {
            String substring = line.substring(i, i + digitLength);
            if (substring.equals("one"))
                return '1';
            if (substring.equals("two"))
                return '2';
            if (substring.equals("six"))
                return '6';
        }

        digitLength = 4;
        if (i <= n - digitLength) {
            String substring = line.substring(i, i + digitLength);
            if (substring.equals("four"))
                return '4';
            if (substring.equals("five"))
                return '5';
            if (substring.equals("nine"))
                return '9';
        }

        digitLength = 5;
        if (i <= n - digitLength) {
            String substring = line.substring(i, i + digitLength);
            if (substring.equals("three"))
                return '3';
            if (substring.equals("seven"))
                return '7';
            if (substring.equals("eight"))
                return '8';
        }

        return '0';
     }
}