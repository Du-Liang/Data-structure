package du.liang.Tree;

import du.liang.Tree.printer.BinaryTrees;

import java.util.Comparator;

public class main {
    static Integer data[]=new Integer[]{
            13,14,15,12,11,17,16,8,9,1
    };
    private static class PersonComparator implements Comparator<Person>{

        @Override
        public int compare(Person e1, Person e2) {
            return e1.getAge()-e2.getAge();
        }
    }
    private static class PersonComparator2 implements Comparator<Person> {

        @Override
        public int compare(Person e1, Person e2) {
            return -(e1.getAge()-e2.getAge());
        }
    }
    static void test(){
        BinarySearchTree<Integer> bst=new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);
        bst.InorderTraversal();
        System.out.println();
        bst.inorder(new BinarySearchTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.println("it is "+(1+element));
                return false;
            }
        });
    }
    static void test2(){
        BinarySearchTree<Person> bstp=new BinarySearchTree<>(new PersonComparator2());
        BinarySearchTree<Person> bstp1=new BinarySearchTree<>(new PersonComparator());

        for (int i = 0; i < data.length; i++) {
            bstp.add(new Person(data[i]));
            bstp1.add(new Person(data[i]));

        }
        BinaryTrees.println(bstp);
        bstp.add(new Person(9));
        System.out.println("netx");
        BinaryTrees.println(bstp);
    }
    static void test3(){
        Integer data[]=new Integer[]{
                13,14,15,12,11,17,16,8,9,1
//                7,4,9,2,5,9,99
        };
        BinarySearchTree<Integer> bst=new AVLTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);
        bst.remove(9);
        BinaryTrees.println(bst);

    }
    public static int a=3;
    public static void main(String[] args) {
        test3();
    }

}

