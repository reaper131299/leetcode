package leetcode.medium;

public class Powxn {

    public static void main(String args[]) {
        Powxn p = new Powxn();
        p.myPow(2.10000, 3);
    }

    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(x == 1 || x == 0) return x;

        if(n<0) return 1/powUtil(x, -1*(long)n);
        return powUtil(x, n);
    }

    public double powUtil(double x, long n){
        if(n == 0) return 1;
        if(n == 1) return x;

        double half = powUtil(x, n/2);

        if(n%2 == 1) return half*half*x;
        return half*half;
    }
}
