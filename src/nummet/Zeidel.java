package nummet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


class Zeidel {
    public static final int MAX_ITERATIONS = 1000;
    static double[][] M;
    static int n;
    public Zeidel(double[][] matrix) { M = matrix; }

    public void print() {
        int n = M.length;

    }

    public boolean transformToDominant(int r, boolean[] V,
                                       int[] R)
    {
        int n = M.length;
        if (r == M.length) {
            double[][] T = new double[n][n + 1];
            for (int i = 0; i < R.length; i++) {
                for (int j = 0; j < n + 1; j++)
                    T[i][j] = M[R[i]][j];
            }
            M = T;
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (V[i])
                continue;
            double sum = 0;
            for (int j = 0; j < n; j++)
                sum += Math.abs(M[i][j]);
            if (2 * Math.abs(M[i][r]) > sum) {

                V[i] = true;
                R[r] = i;
                if (transformToDominant(r + 1, V, R))
                    return true;
                V[i] = false;
            }
        }
        return false;
    }
    public static void Swap(double[][] M, int x, int y) {
        double[] tmp = M[x];
        M[x] = M[y];
        M[y] = tmp;
    }


    public boolean makeDominant()
    {
        boolean[] visited = new boolean[M.length];
        int[] rows = new int[M.length];
        Arrays.fill(visited, false);
        return transformToDominant(0, visited, rows);
    }


    public void solve()
    {
        int iterations = 0;
        int n = M.length;
        double epsilon = 0.01;
        double[] X = new double[n];
        double[] P = new double[n];
        Arrays.fill(X, 0);
        while (true) {
            for (int i = 0; i < n; i++) {
                double sum = M[i][n];
                for (int j = 0; j < n; j++)
                    if (j != i)
                        sum -= M[i][j] * X[j];

                X[i] = 1 / M[i][i] * sum;


            }
            iterations++;
            if (iterations == 1)
                continue;
            boolean stop = true;
            for (int i = 0; i < n && stop; i++)
                if (Math.abs(X[i] - P[i]) > epsilon)
                    stop = false;
            if (stop || iterations == MAX_ITERATIONS)
                break;
            P = (double[]) X.clone();

        }
        System.out.println("Iterations: "+ iterations);
    }

    public static void main(String[] args)
            throws IOException
    {
        PrintWriter writer
                = new PrintWriter(System.out, true);
        Scanner scanner = new Scanner(System.in);
        System.out.println("n: " );
        int n = scanner.nextInt();
        double[][] M = new double[n][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                M[i][j] = scanner.nextInt();
            }
        }
        Swap(M, 0, 1);
        Swap(M, 1, 2);

        Zeidel Seidel = new Zeidel(M);

        writer.println();
        Seidel.print();
        Seidel.solve();
    }

}
