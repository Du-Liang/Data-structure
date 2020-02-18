package du.liang.Tree;

import du.liang.Tree.printer.BinaryTreeInfo;

import java.util.Comparator;

public class BinarySearchTree<E> implements BinaryTreeInfo {
    private int size=0;
    private Node<E> root;
    private Comparator<E> comparator;

    public BinarySearchTree() {
        this.comparator=null;
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node)node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node)node).right;
    }

    private class Node<E> {
        E element;
        Node left;
        Node right;
        Node parent;
        public Node(E element, Node<E> parent){
            this.element=element;
            this.parent=parent;
        }
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size==0;
    }
    public void clear(){

    }
    public void add(E element){
        elementNotNullCheak(element);
        //添加第一个节点（根节点）
        if(root==null){
            root=new Node<>(element,null);
            size++;
            return;
        }
        //添加的不是第一个节点（非根节点）
        Node node=root;
        Node parent=root;
        int cmp=0;
        while (node!=null){
            parent=node;
            cmp=compare(element,(E)node.element);
            if(cmp>0){
                node=node.right;
            }else if(cmp<0 ){
                node=node.left;
            }if(cmp==0){//相等的情况
                return;
            }
        }

        if(cmp>0){
            parent.right=new Node<E>(element,parent);
        }else {
            parent.left=new Node<E>(element,parent);
        }
        size++;
    }
    /*
    * @return 返回值等于0：e1=e2，返回值大于0：e1>e2，
    * 返回值小于0：e1<e2。
    * */
    @SuppressWarnings("unchecked")
    private int compare(E e1,E e2){
        if(comparator!=null){
            return comparator.compare(e1,e2);
        }else {
            return ((Comparable)e1).compareTo(e2);
        }
    }
    public void remove(E element){

    }
    public boolean contain(E element){
        return false;
    }
    private void elementNotNullCheak(E element){
        if(element==null){
            throw new IllegalArgumentException("element must" +
                    "not be null");
        }
    }

}
