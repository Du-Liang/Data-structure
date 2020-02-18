package du.liang.Tree;

import du.liang.Tree.printer.BinaryTrees;
import jdk.nashorn.api.tree.BinaryTree;

import java.util.Comparator;

public class main {
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
    public static void main(String[] args) {
        Integer data[]=new Integer[]{
                7,4,9,2,5,8,11,3
        };

        BinarySearchTree<Integer> bst=new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);

        BinarySearchTree<Person> bstp=new BinarySearchTree<>(new PersonComparator());
        bstp.add(new Person(1));
        bstp.add(new Person(2));
        bstp.add(new Person(3));
        BinarySearchTree<Person> bstp2=new BinarySearchTree<>((o1, o2) -> o2.getAge()-o1.getAge());
        bstp.add(new Person(1));
        bstp.add(new Person(2));
        bstp.add(new Person(3));
        BinarySearchTree<Person> bstp3=new BinarySearchTree<>();
        bstp.add(new Person(1));
        bstp.add(new Person(2));
        bstp.add(new Person(3));

    }

}

