package classwork.chapter7.recursion;

public class Recursion {
    //Example in factorial

    int factorial(int n){
        if (n == 1) return 1;
        else if (n == 0) {
            return 0;
        }
        return factorial(n - 1) * n;
    }
}
