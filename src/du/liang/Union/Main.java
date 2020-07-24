package du.liang.Union;

public class Main {
    public static void main(String[] args) {
        System.out.println(sum(10));

    }
    public static int sum(int n){
        if(n <= 1) return n;
        return n+sum(n-1);
    }
}
