package du.liang.LinkedList;


import du.liang.LinkedList.singlelist.CircleSingleLinkedList;

public class Main {
    public static void main(String[] args) {
        List<Integer> list=new CircleSingleLinkedList<>();

        java.util.LinkedList<Integer> ty;

        list.add(20);

        list.add(30);
        list.add(list.size(),40);
        System.out.println(list);
        list.add(0,999);
        System.out.println(list);
    }
}
