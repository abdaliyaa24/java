package mcm;

public class Thomas {


    public static void main(String... args) {
        int i;
        int n = 101;
        double dx,dt,a,b,c;
        double d[]= new double[n];
        double f[]= new double[n];
               double alfa[]= new double[n];
               double betta[]= new double[n];
               double newU[]= new double[n];
               double oldU[] = new double[n];
                double eps = 0.0000001;
                double max;
        for(i=1;i<n;i++){
            newU[i]=0;
        }
        newU[0]=1;
        newU[n-1]=0;
        oldU[0]=1;
        oldU[n-1]=0;
        dx=1.0/(n-1);
        dt=0.5*dx*dx;

        a=1.0/(dx*dx);
        b=-1.0/dt-2.0/(dx*dx);
        c=1.0/(dx*dx);
        do {
                alfa[1] = 0.0;
                betta[1] = 1.0;

            for(i=1;i<n-1;i++) {
                d[i]=- oldU[i]/dt;
                alfa[i+1]=-a/(b+c*alfa[i]);
                betta[i+1]=(d[i]-c*betta[i])/(b+c*alfa[i]);
            }
            newU[n-1]=(betta[i]/(1-alfa[i]));
            for(i=n-1;i>1;i--) {
                newU[i-1] = alfa[i] * newU[i] + betta[i];
            }
            max=0.0;
            for(i=0;i<n;i++)
                if(max<Math.abs(newU[i]-oldU[i]))
                max=Math.abs(newU[i]-oldU[i]);
            for(i=0;i<n;i++)
                oldU[i]=newU[i];
             }
        while(max>eps);
        for(i=0;i<n;i++)
            System.out.println(oldU[i]);
    }
    }



