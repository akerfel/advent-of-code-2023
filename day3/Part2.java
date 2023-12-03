import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public static void main(String[] args) throws IOException {
        char[][] m = getInputAsMatrix(args[0]);
        int height = m.length;
        int width = m[0].length;

        int sum = 0;
        for (int y = 1; y < height - 1; y++) {
            for (int x = 1; x < width - 1; x++) {
                if (isGear(m, y, x)) {
                    sum += gearRatio(m, y, x);
                }
            }
        }
        System.out.println(sum);
    }

    public static int gearRatio(char[][] m, int y1, int x1) {
        int gearRatio = 1;
        for (int y = y1 - 1; y <= y1 + 1; y++) {
            for (int x = x1 - 1; x <= x1 + 1; x++) {
                if (isDigit(m, y, x)) {
                    while (isDigit(m, y, x)) {
                        x--;
                    }
                    x++;

                    String stringNum = "";
                    while(isDigit(m, y, x)) {
                        stringNum += m[y][x];
                        x++;
                    }
                    int num = Integer.parseInt(stringNum);
                    gearRatio *= num;
                }
            }
        }
        return gearRatio;
    }

    public static boolean isGear(char[][] m, int y1, int x1) {
        if (m[y1][x1] != '*') return false;

        int adjacentNumbers = 0;
        for (int y = y1 - 1; y <= y1 + 1; y++) {
            for (int x = x1 - 1; x <= x1 + 1; x++) {
                if (isDigit(m, y, x)) {
                    adjacentNumbers++;
                    while (isDigit(m, y, x)) {
                        x++;
                    }
                }
            }
        }
        return adjacentNumbers == 2;
    }

    public static boolean isSymbol(char c) {
        return !Character.isDigit(c) && c != '.';
    }

    public static boolean isSymbol(char[][] m, int y, int x) {
        return isSymbol(m[y][x]);
    }

    public static boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    public static boolean isDigit(char[][] m, int y, int x) {
        return isDigit(m[y][x]);
    }

    public static char[][] getInputAsMatrix(String fileName) throws IOException {
        List<String> lines = new ArrayList<String>();
        BufferedReader bf = new BufferedReader(new FileReader(fileName));
        String line = bf.readLine();
        while (line != null) {
            lines.add(line);
            line = bf.readLine();
        }
        bf.close();

        // Create matrix with an extra outer layer of '.' characters
        int height = lines.size() + 2;
        int width = lines.get(0).length() + 2;
        char[][] m = new char[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x == 0 || x == width - 1 || y == 0 || y == height - 1) {
                    m[y][x] = '.';
                }
                else {
                    m[y][x] = lines.get(y - 1).charAt(x - 1);
                }
            }
        }

        return m;
    }
}
