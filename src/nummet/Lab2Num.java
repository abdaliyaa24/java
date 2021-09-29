package nummet;

public class Lab2Num {
    public static void main(String[] args) {
            int N = 30;
            int M = 100;
            int a = 0;
            int b = 4;
            int d = 15;
            double c = 0.8;
            double xi = 4.0/30.0;
            double tj = 0.15;
            double U[][] = new double[N][M];
            double Uexact[][] = new double[N][M];
            double Ur[][] = new double[N][M];
            double Ul[][] = new double[N][M];
            double Uc[][] = new double[N][M];
            double rDelta[][] = new double[N][M];
            double lDelta[][] = new double[N][M];
            double cDelta[][] = new double[N][M];
            double t[] = new double[d];
            double x[] = new double[b];

            for (int i = 0; i < b; i++) {
                x[i] = i * xi;
            }
            for (int i = 0; i  < d;i++) {
                t[i] = i * tj;
            }

            for (int i = 0; i < b; i++) {

                U[i][0] = 3 * Math.sin(x[i]) + 7;
                Ul[i][0] = 3 * Math.sin(x[i]) + 7;
                Uc[i][0] = 3 * Math.sin(x[i]) + 7;
            }
            for (int i = 0; i < b; i++) {
                for (int j = 0; j < d; j++) {
                    Uexact[i][j] = 3 * Math.sin(x[i] - c * t[j]) + 7;
                    System.out.println(Uexact[i][j]);
                }
            }

            for (int i = 0; i < b-1; i++) {
                for (int j = 0; j < d-1; j++) {
                    Ur[i][j+1]=U[i][j] - c*tj/xi * (U[i+1][j]-U[i][j]);
                }
            }
            for (int i = 1; i < b; i++) {
                for (int j = 0; j < d; j++) {
                    Ul[i][j+1]=U[i][j] - c*tj/xi * (U[i][j]-U[i-1][j]);
                }
            }
            for (int i = 1; i < b-1; i++) {
                for (int j = 0; j < d; j++) {
                    Uc[i][j+1]=U[i][j] - c*tj/(2*xi) * (U[i+1][j]-U[i-1][j]);
                }
            }
            for (int i = 1; i < b-1; i++) {
                for (int j = 1; j < d-1; j++) {
                    rDelta[i][j] = (Uexact[i][1] - Ur[i][1]);
                    System.out.println("Right delta: " + rDelta[i][j]);
                }
            }

                    for (int i = 0; i < b; i++) {
                        for (int j = 0; j < d; j++) {
                            lDelta[i][j] = (Uexact[i][1] - Ul[i][1]);
                            System.out.println("Left delta: " + lDelta[i][j]);
                        }
                    }

                    for (int i = 1; i < b-1; i++) {
                   for (int j = 1; j < d-1; j++) {
                    cDelta[i][j] = (Uexact[i][1]-Uc[i][1]);

                    System.out.println("Central delta: " + cDelta[i][j]);
                }
            }
        }
    }