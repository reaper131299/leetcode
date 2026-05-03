package leetcode.medium;

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while ((a & b) !=0) {
            int tempa = a;
            int tempb = b;
            a = tempa ^ tempb;
            b = (tempa & tempb) << 1;
        }

        return a;
    }
}
