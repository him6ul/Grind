package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        List<String> checks = new ArrayList<>();
        floodFill(checks, image, sr, sc, color);

        for (String s : checks) {
            String[] dataArray = s.split("_");
            image[Integer.parseInt(dataArray[0])][Integer.parseInt(dataArray[1])] = color;
        }
        return image;
    }

    private static void floodFill(List<String> checks, int[][] image, int sr, int sc, int color) {
        String key = sr + "_" + sc;
        if (checks.contains(key))
            return;

        checks.add(key);

        if (sr > 0 && sr <= image.length && image[sr - 1][sc] == image[sr][sc]) {
            floodFill(checks, image, sr - 1, sc, color);
        }

        if (sr >= 0 && sr < image.length - 1 && image[sr + 1][sc] == image[sr][sc]) {
            floodFill(checks, image, sr + 1, sc, color);
        }

        if (sc > 0 && sc <= image[0].length && image[sr][sc - 1] == image[sr][sc]) {
            floodFill(checks, image, sr, sc - 1, color);
        }

        if (sc >= 0 && sc < image[0].length - 1 && image[sr][sc + 1] == image[sr][sc]) {
            floodFill(checks, image, sr, sc + 1, color);
        }
    }

    public static void main(String[] args) {
        System.out.println("Checking what is happening here.");
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(Arrays.deepToString(floodFill(image, 1, 1, 2)));
        int[][] image1 = {{0, 0, 0}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(floodFill(image1, 0, 0, 0)));
    }
}
