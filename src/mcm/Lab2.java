package mcm;

public class Lab2 {
    public static void main(String[] args) {
        int n=101;
        double e=1e-7;

        double ro=2698.9;
        double c=920;
        double k=202;
        double q=k/(ro*c);

        double a=0,b=1;
        double dx=(b-a)/n;
        double dt=(dx*dx)/(2*q);

        double uOld[]=new double[n];
        double uNew[]=new double[n];
        for(int i=1;i<n;i++){
            uNew[i]=0;
        }
        uNew[0]=1;
        uNew[n-1]=0;
        uOld[1]=0;
        uOld[n-1]=0;
        double max;
        do{

            for(int i=1;i<n-1;i++){
                uOld[i]=(q*dt/(dx*dx))*(uNew[i+1]-2*uNew[i]+uNew[i-1])+uNew[i];
            }
            uOld[n-1]=uOld[n-2];
            max=0;
            for (int i = 1; i <=n-1; i++) {
                if (max < Math.abs(uOld[i] - uNew[i])){
                    max = Math.abs(uOld[i] - uNew[i]);
                }
                uNew[i] = uOld[i];
            }
        }while(max>e);

        for(int i=0;i<n;i++) {
            System.out.println(uOld[i]);

        }

    }

}


