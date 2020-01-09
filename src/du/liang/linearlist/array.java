package du.liang.linearlist;

import du.liang.tools.Asserts;

public class array {
    public static void main(String[] args) {
        java.util.ArrayList tr = new java.util.ArrayList<Integer>(-1);
        ArrayList my_a =new ArrayList();
//        System.out.println(my_a.size());
//        my_a.add(999);
//        my_a.add(99);
//        my_a.add(9);
        for (int i = 0; i < 10; i++) {
            my_a.add(i);
        }
        System.out.println();
        System.out.println(my_a);
//        my_a.add(7,96);
        my_a.clear();
        System.out.println(my_a);

    }
}


