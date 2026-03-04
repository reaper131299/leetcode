package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String args[]) {
        GenerateParentheses g = new GenerateParentheses();
        g.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        List<String> s = new ArrayList<>();
        int openCount = 1;
        int closeCount = 0;
        generate(s, "(", openCount, closeCount, n);
        return s;
    }

    public void generate(List<String> s, String p, int openCount, int closeCount, int n) {
        if (openCount < closeCount) {
            return;
        }
        if (openCount == n &&  closeCount == n) {
            s.add(p);
        }
        if (openCount < n) {
            generate(s, p + "(", openCount + 1, closeCount, n);
        }
        if(closeCount < n) {
            generate(s, p + ")", openCount, closeCount + 1, n);
        }
    }
}
