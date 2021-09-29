package mcm;

public class BurgersSndUpwind {
    public static void main(String[] args) {
        int n=101;
        double Re=10;
        double eps=1e-4;
        double a=0,b=1;
        double dx=(b-a)/n;

        double dt=(dx*dx)*Re/2;
        double uOld[]=new double[n+1];
        double uNew[]=new double[n+1];

        for(int i=1;i<n;i++){
            uOld[i]=0;
            uNew[i]=0;
        }
        uOld[0]=1;
        uOld[n]=0;
        uNew[0]=1;
        uNew[n]=0;

        double max,t;
        double ur,ul,er,el,e;
        do{
            max=0;
            for(int i=1;i<n;i++) {
                ur = (uOld[i + 1] + uOld[i]) / 2;
                ul = (uOld[i] + uOld[i - 1]) / 2;

                er = ur * (uNew[i + 1] + uNew[i]) + (0 - ur) * (uNew[i + 1] - uNew[i]);
                el = ul * (uNew[i - 1] + uNew[i]) + (0 - ul) * (uNew[i - 1] - uNew[i]);
                t = (er - el) / 2;
                uNew[i] = dt * (uOld[i + 1] - 2 * uOld[i] + uOld[i - 1]) / (Re * dx * dx) + uOld[i] - dt * t;
            }

            max = Math.abs(uNew[1] - uOld[1]);
            for (int i = 2; i<=n; i++) {
                if (max<Math.abs(uNew[i] - uOld[i]))
                    max = Math.abs(uNew[i] - uOld[i]);
            }

            for (int i = 1; i <=n-1; i++){
                uOld[i] = uNew[i];
            }

        }while(max>eps);

        for(int i=0;i<n;i++)
            System.out.println(uNew[i]);

    }

    }

