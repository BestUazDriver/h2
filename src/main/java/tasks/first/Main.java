package tasks.first;

import java.util.Scanner;

public class Main {
//test class

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("vertex?");
        int n = scanner.nextInt();
        boolean[][] m = new boolean[n][n];
        for (int i = 0; i < m.length; i++) {
            for (int y = i + 1; y < m.length - 1; y++) {
                m[i][y] = scanner.nextBoolean();
                m[i][i] = false;
                m[y][i] = m[i][y];
            }
        }
        for (int i = 0; i < m.length; i++) {
            for (int y = 0; y < m.length; y++) {
                System.out.print(m[i][y] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(new FirstTaskSolution().breadthFirst(m, 2));
    }
}
