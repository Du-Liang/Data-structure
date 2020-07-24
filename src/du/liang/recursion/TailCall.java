package du.liang.recursion;

public class TailCall {
    public static void main(String[] args) {
        System.out.println(facttorial(4));
    }
    static int facttorial(int n){

        return facttorial(n, 1);
    }
    static int facttorial(int n, int result){
        if(n<=1) return result;
        return facttorial(n-1, result*n);
    }
}

