package du.liang.LinkedList;

public class Main {
    public static void main(String[] args) {
        List<Integer> list=new LinkedList<>();

//        for (int i = 0; i < 10; i++) {
//            list.add(i);
//        }
//        list.add(5,666);
//        System.out.println(list);
//        list.remove(9);
//        System.out.println(list);
        list.add(20);
        list.add(0,10);
        list.add(30);
        list.add(list.size(),40);
        list.remove(1);
        System.out.println(list);
    }
}
