package du.liang.recursion;

public class Hanoi {
    public static void main(String[] a){
        Hanoi hi = new Hanoi();
        hi.hanoi(10,"A", "B", "C");
    }
    void hanoi(int n, String p1, String p2, String p3){
        /**
         * 将 n 个碟子从p1 挪动到 p3
         * p2 中间的柱子
         */
        if(n <= 1){
            move(n,p1,p3);
            return;
        }
        hanoi(n-1, p1, p3, p2);
        move(n,p1,p3);
        hanoi(n-1,p2,p1,p3);
    }

    /**
     * "将"+num+"号盘子从 "+from+" 移动到 "+to
     * @param num
     * @param from
     * @param to
     */
    void move(int num, String from, String to){
        System.out.println("将"+num+"号盘子从 "+from+" -> "+to);


    }
}
