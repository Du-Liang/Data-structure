package du.liang.Tree;

import du.liang.Tree.printer.BinaryTrees;

import java.util.Comparator;

public class main {
    static Integer data[]=new Integer[]{
            7,4,2,1,3,5,9,8,11,10,12,
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
                7,4,2,1,9,
//                7,4,9,2,5,9,99
        };
        BinarySearchTree<Integer> bst=new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);
        System.out.println(bst.isComplete() );


//        System.out.println(bst.height());
//        System.out.println(bst.height2());
//        System.out.println("前序：");
//        a=3;
//        bst.preorder(new BinarySearchTree.Visitor<Integer>() {
//            @Override
//            public boolean visit(Integer element) {
//                System.out.print((element)+" ");
//                a--;if (a==0)return true;
//                return false;
//            }
//        });
//        System.out.println("\n"+"中序：");
//        a=3;
//        bst.inorder(new BinarySearchTree.Visitor<Integer>() {
//            @Override
//            public boolean visit(Integer element) {
//                System.out.print((element)+" ");
//                a--;if (a==0)return true;
//                return false;
//
//            }
//        });
//        System.out.println("\n"+"后序：");
//        a=3;
//        bst.postorder(new BinarySearchTree.Visitor<Integer>() {
//
//            @Override
//            public boolean visit(Integer element) {
//
//                System.out.print((element)+" ");
//                a--;if (a==0)return true;
//                return false;
//            }
//        });
//
//        System.out.println("\n"+"层序:");
//        a=3;
//        bst.LevelOrderTraversal(new BinarySearchTree.Visitor<Integer>() {
//            @Override
//            public boolean visit(Integer element) {
//                System.out.print((element)+" ");
//                a--;if (a==0)return true;
//                return false;
//            }
//        });
    }
    public static int a=3;
    public static void main(String[] args) {
        test3();
    }

}

