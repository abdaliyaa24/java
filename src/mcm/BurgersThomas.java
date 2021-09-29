package mcm;

public class BurgersThomas {
    public static void main(String[] args) {
        int i;
        int n = 101;
        double dx, dt;
        double A[] = new double[n];
        double B[] = new double[n];
        double C[] = new double[n];
        double D[] = new double[n];
        double alfa[] = new double[n];
        double betta[] = new double[n];
        double uNew[] = new double[n];
        double uOld[] = new double[n];
        double eps, max, Re;
        dx = 1.0 / (n - 1);
        dt = 0.5*dx*dx;
        eps = 1e-4;
        Re = 10.0;
            uOld[1] = 0.0;
        do {
            for (i = 0; i < n; i++) {
                A[i] = uOld[i] / dx - 1.0 / (Re * dx * dx);
                B[i] = 1 / dt - uOld[i] / dx + 2.0 / (Re * dx * dx);

                C[i] = -1.0 / (Re * dx * dx);

                D[i] = uOld[i] / dt;
            }
            alfa[1] = 0.0;
            betta[1] = 1.0;
            for (i = 1; i < n-1; i++) {
                alfa[i + 1] = -1* A[i] / (B[i] + C[i] * alfa[i]);
                betta[i + 1] = (D[i] - C[i] * betta[i]) / (B[i] + C[i] * alfa[i]);
            }
            uNew[n-1] = betta[i]/(1-alfa[i]);
            for (i = n - 2; i >= 0; i--)
                uNew[i] = alfa[i + 1] * uNew[i + 1] + betta[i + 1];
            max = 0.0;
            for (i = 0; i < n; i++)
                if (max < Math.abs(uNew[i] - uOld[i]))
                    max = Math.abs(uNew[i] - uOld[i]);
            for (i =0; i < n; i++)
                uOld[i] = uNew[i];
        } while (max > eps);
        for (i = 0; i < n; i++)
            System.out.println(uNew[i]);

    }
}
