package du.liang.recursion;

public class Fib {
    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib4(11));
    }
    //滚动数组优化 时间复杂度O(n) 空间复杂度O(1)
    int fib4(int n){
        if(n<=2) return 1;
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++){
            array[i&1] = array[(i-1)&1] + array[(i-2)&1];
        }
        return array[n&1];
    }
    //两个变量相互覆盖的方法 时间复杂度O(n) 空间复杂度O(1)
    int fib3(int n){
        if(n <= 2) return 1;
        int a=1, b=1, sum = 0;
        for(int i=2;i<n;i++){
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
    static int fib(int n){
        int[] array = new int[n+1];
        array[1] = 1;
        array[2] = 1;
        return fib(n,array);
    }
    static int fib(int n, int[] array){
        if(array[n] == 0){
            array[n] = fib(n-1, array) + fib(n-2, array);
        }
        return array[n];
    }
    static int fib0(int n){
        if(n<=2) return 1;
        return fib0(n-1) + fib0(n-2);
    }
}
