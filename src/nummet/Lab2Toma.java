package nummet;

public class Lab2Toma {
    public static void main(String[] args){
        int a = 0, b = 4, ta = 0, tb = 15, n = 50, m = 100;
        double c = 0.8;
        double[][] u = new double[4][15];

        double dt = 0.15;
        double dx = 4.0/50.0;

        double[] tj = new double[tb];
        double[] xi = new double[b];
        double[][] uex = new double[n][m];

        double[][] ur = new double[n][m];
        double[][] ul = new double[n][m];
        double[][] uc = new double[n][m];

        double[][] urex = new double[n][m];
        double[][] ulex = new double[n][m];
        double[][] ucex = new double[n][m];

        for (int i = 0; i < b; i++) {
            xi[i] = i * dx;
        }

        for (int i = 0; i < tb; i++) {
            tj[i] = i * dt;
        }

        for (int i = 0; i < b; i++) {
            u[i][0] = 3 * Math.sin(xi[i]) + 7;
            ul[i][0] = 3 * Math.sin(xi[i]) + 7;
            uc[i][0] = 3 * Math.sin(xi[i]) + 7;
        }

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < tb; j++) {
                uex[i][j] = 3*Math.sin(xi[i]-c*tj[j])+7;
                System.out.println(uex[i][j]);
            }
        }
        System.out.println("ur");
        for (int i = 0; i < b-1; i++) {
            for (int j = 0; j < tb-1; j++) {
                u[i][j+1] = u[i][j]-c*(dt/dx)*(u[i+1][j]-u[i][j]);
                System.out.println(u[i][j]);
            }
        }
        System.out.println("ul");
        for (int i = 1; i < b; i++) {
            for (int j = 0; j < tb; j++) {
                ul[i][j+1] = ul[i][j]-c*(dt/dx)*(ul[i][j]-ul[i-1][j]);
                System.out.println(ul[i][j]);
            }
        }
        System.out.println("uc");
        for (int i = 1; i < b-1; i++) {
            for (int j = 0; j < tb; j++) {
                uc[i][j+1] = uc[i][j]-c*dt/dx*((uc[i+1][j]-uc[i-1][j])/(2*dx));
                System.out.println(uc[i][j]);
            }
        }
        System.out.println("delta right: ");
        for (int i = 1; i < b-1; i++) {
            for (int j = 1; j < tb-1; j++) {
                urex[i][j] = uex[i][1]-u[i][1];
                System.out.println(urex[i][j]);
            }
        }
        System.out.println("delta left: ");
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < tb; j++) {
                ulex[i][j] = uex[i][1]-ul[i][1];
                System.out.println(ulex[i][j]);
            }
        }
        System.out.println("delta center: ");
        for (int i = 1; i < b-1; i++) {
            for (int j = 1; j < tb-1; j++) {
                ucex[i][j] = uex[i][1]-uc[i][1];
                System.out.println(ucex[i][j]);
            }
        }
    }
}
