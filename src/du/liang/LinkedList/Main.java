package du.liang.LinkedList;

public class Main {
    public static void main(String[] args) {
        CircleLinkedList<Integer> list=new CircleLinkedList<>();
        for (int i = 1; i <=8; i++) {
            list.add(i);
        }
        System.out.println(list);
        list.reset();
        //josephus prbolem
        while (list.size!=0){
            for (int i = 0; i < 2; i++) {
                System.out.println("当前是："+list.next());

            }
            System.out.println("删除了"+list.kill());
            System.out.println(list );


        }
//        list.add(0,55);
//        while (list.size!=0){
//
//            list.remove(0);
//        }
        System.out.println(list );
    }
}
