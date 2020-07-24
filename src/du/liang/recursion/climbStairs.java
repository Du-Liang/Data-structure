package du.liang.recursion;

public class climbStairs {

    public static void main(String[] a){
        climbStairs cl = new climbStairs();
        System.out.println(cl.climbStairs(9));
        System.out.println(cl.climbStairs1(9));
    }

    int climbStairs(int n){
        if(n <= 2) return n;
        return climbStairs(n-1) + climbStairs(n-2);
    }
    int climbStairs1(int n){
        if(n <= 2) return n;
        int first=1, second=2, sum=0;
        for(int i = 3; i <= n; i++){
            sum = first + second;
            first = second;
            second = sum;

        }
        return sum;
    }
}
