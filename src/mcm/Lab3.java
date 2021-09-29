package mcm;

public class Lab3 {
    private static double func(double x){
        return Math.exp(x);
    }
    public static void main(String[] args) {
        int i = 0;
        int n = 101;
        double gamma[] = new double[n];
        double numSolution[] = new double[n];
        double f[] = new double[n];
        double[] a = new double[n];
        double b[] = new double[n];
        double c[] = new double[n];
        double d[] = new double[n];
        double e[] = new double[n];
        double h[] = new double[n];

        double g = 0, v = 1;
        double alfa[] = new double[n];
        double betta[] = new double[n];
        double step = (v-g)/(n-1);
        double dx = 1.0 / (n - 1);
        for (i = 0; i < n; i++) numSolution[i] = 0.0;
        for (i = 0; i < n; i++) f[i] = 0.0;
        for (i = 0; i < n; i++) {
            a[i] = -1.0 / (12.0 * dx * dx);
            b[i] = 16.0 / (12.0 * dx * dx);
            c[i] = -30.0 / (12.0 * dx * dx);
            d[i] = 16.0 / (12.0 * dx * dx);
            e[i] = -1.0 / (12.0 * dx * dx);
            h[i] = -f[i];
        }
        alfa[1] = 0.0;
        betta[1] = 0.0;
        gamma[1] = 1.0;
        alfa[2] = -(b[1] + d[1] * betta[1]) / (c[1] + d[1] * alfa[1]);
        betta[2] = -a[1] / (c[1] + d[1] * alfa[1]);
        gamma[2] = (h[1] - d[1] * gamma[1]) / (c[1] + d[1] * alfa[1]);
        for (i = 2; i < n - 1; i++) {
            alfa[i + 1] = -(b[i] + d[i] * betta[i] + e[i] * alfa[i -
                    1] * betta[i]) / (c[i] + d[i] * alfa[i] + e[i] * alfa[i - 1] * alfa[i] + e[i] * betta[i - 1]);
            betta[i + 1] = -a[i] / (c[i] + d[i] * alfa[i] + e[i] * alfa[i - 1] * alfa[i] + e[i] * betta[i - 1]);
            gamma[i + 1] = (h[i] - d[i] * gamma[i] - e[i] * alfa[i - 1] * gamma[i] - e[i] * gamma[i -
                    1]) / (c[i] + d[i] * alfa[i] + e[i] * alfa[i - 1] * alfa[i] + e[i] * betta[i - 1]);
        }
        numSolution[n - 1] = 0.0;
        System.out.println("Numerical solution:");
        for (i = n - 3; i > 0; i--) {
            numSolution[i] = alfa[i + 1] * numSolution[i + 1] + betta[i + 1] * numSolution[i + 2] + gamma[i + 1];
            System.out.println(numSolution[i]);
        }
        System.out.println("Exact solution of the function: ");

        for (double s =v; s >= g; s-= step) {
            System.out.println(func(s) - func(1) * s);
        }
    }

}

