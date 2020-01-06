package du.liang.BigO;

public class main {
    public static void main(String[] args) {
        int n=5;
        for (int i = 1; i < n; i += i) {
            // 1 + 3n
            for (int j = 0; j < n; j++) {
                System.out.println("test");
            }
        }
//        Times.test("fibonacci",()->{
//            fibonacci(40);
//        });
//        Times.test("",()->{
//            fibonacciRe(40);
//        });
//        for (int i = 1; i < 10; i++) {
//            System.out.print (fibonacciRe(5));
//
//        }

//        for (int i:fibonacciRe(10)
//             ) {
//            System.out.print (i+" ");
//        }
    }

//    斐波那契数列
    public static int[] fibonacciRe(int n){
        int [] FibArray=new int[n];
        FibArray[0]=1;
        FibArray[1]=1;
        for (int i = 2; i < n; i++) {
            FibArray[i]=FibArray[i-1]+FibArray[i-2];
        }


        return FibArray;
    }
    public static int fibonacci(int n){
        if(n==1) return 1;
        else if (n==2) return 1;
        else return fibonacci(n-1)+fibonacci(n-2);
    }
}
