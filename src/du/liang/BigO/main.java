package du.liang.BigO;

public class main {
    public static void main(String[] args) {
        System.out.print(fib(2));
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
    public static int fibonacci(int N){
        if(N==0) return 1;
        if(N==1) return 1;
        else if (N==2) return 1;
        else return fibonacci(N-1)+fibonacci(N-2);
    }
    public static int fib(int N){
        if(N<=1) return N;
        int first=0;
        int second=1;
        for (int i = 0; i < N-1; i++) {
            int sum=second+first;
            first =second;
            second=sum;
        }
        return second;
    }
}

/**
 * public static void test1(int n) {
 * 		// 汇编指令
 *
 * 		// 1
 * 		if (n > 10) {
 * 			System.out.println("n > 10");
 *          } else if (n > 5) { // 2
 * 			System.out.println("n > 5");
 *        } else {
 * 			System.out.println("n <= 5");
 *        }
 *
 * 		// 1 + 4 + 4 + 4
 * 		for (int i = 0; i < 4; i++) {
 * 			System.out.println("test");
 *        }
 *
 * 		// 140000
 * 		// O(1)
 * 		// O(1)* 	}
 *
 * 	public static void test2(int n) {
 * 		// O(n)
 * 		// 1 + 3n
 * 		for (int i = 0; i < n; i++) {
 * 			System.out.println("test");
 *        }* 	}
 *
 * 	public static void test3(int n) {
 * 		// 1 + 2n + n * (1 + 3n)
 * 		// 1 + 2n + n + 3n^2
 * 		// 3n^2 + 3n + 1
 * 		// O(n^2)
 *
 * 		// O(n)
 * 		for (int i = 0; i < n; i++) {
 * 			for (int j = 0; j < n; j++) {
 * 				System.out.println("test");
 *            }
 *        }*
 *        }
 *
 * 	public static void test4(int n) {
 * 		// 1 + 2n + n * (1 + 45)
 * 		// 1 + 2n + 46n
 * 		// 48n + 1
 * 		// O(n)
 * 		for (int i = 0; i < n; i++) {
 * 			for (int j = 0; j < 15; j++) {
 * 				System.out.println("test");
 *            }
 *        }* 	}
 *
 * 	public static void test5(int n) {
 * 		// 8 = 2^3
 * 		// 16 = 2^4
 *
 * 		// 3 = log2(8)
 * 		// 4 = log2(16)
 *
 * 		// 执行次数 = log2(n)
 * 		// O(logn)
 * 		while ((n = n / 2) > 0) {
 * 			System.out.println("test");
 *        }* 	}
 *
 * 	public static void test6(int n) {
 * 		// log5(n)
 * 		// O(logn)
 * 		while ((n = n / 5) > 0) {
 * 			System.out.println("test");
 *        }* 	}
 *
 * 	public static void test7(int n) {
 * 		// 1 + 2*log2(n) + log2(n) * (1 + 3n)
 *
 * 		// 1 + 3*log2(n) + 3 * nlog2(n)
 * 		// O(nlogn)
 * 		for (int i = 1; i < n; i = i * 2) {
 * 			// 1 + 3n
 * 			for (int j = 0; j < n; j++) {
 * 				System.out.println("test");
 *            }
 *        }* 	}
 *
 * 	public static void test10(int n) {
 * 		// O(n)
 * 		int a = 10;
 * 		int b = 20;
 * 		int c = a + b;
 * 		int[] array = new int[n];
 * 		for (int i = 0; i < array.length; i++) {
 * 			System.out.println(array[i] + c);
 *        }* 	}
 * }
 */

