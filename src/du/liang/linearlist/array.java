package du.liang.linearlist;

public class array {
    public static void main(String[] args) {
        ArrayList my_a =new ArrayList();
        System.out.println(my_a.size());
//        my_a.add(999);
//        my_a.add(99);
//        my_a.add(9);
        for (int i = 0; i < 7; i++) {
            my_a.add(i);
        }
        System.out.println();
        System.out.println(my_a);
        my_a.add(7,7);
        System.out.println(my_a);
    }
}


