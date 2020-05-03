package du.liang.Tree;

import java.util.Comparator;

public class RBTree<E> extends BinarySearchTree<E>{

    //红色是false
    //黑色是true
    private final boolean BLACK=true;
    private final boolean RED=false;

    public RBTree() {
        this(null);
    }

    public RBTree(Comparator<E> comparator) {
        super(comparator);
    }

    private class BRnode<E> extends Node <E>{


        boolean color;

        public BRnode(E element, Node parent) {
            super(element, parent);
        }
    }

    private BRnode<E> color(Node node,boolean color){
        if(node==null)return null;
        BRnode<E> newnode=(BRnode<E>)node;
        newnode.color=color;
        return newnode;
    }
    private BRnode red(Node node){
        return color(node,RED);
    }
    private BRnode black(Node node){
        return color(node,BLACK);
    }

    private boolean colorOf(Node<E> node){
        return node==null?BLACK:((BRnode<E>)node).color;
    }
    private boolean isBlack(Node<E> node){
        return ((BRnode<E>)node).color==BLACK;
    }
    private boolean isRed(Node<E> node){
        return ((BRnode<E>)node).color==RED;
    }

    @Override
    protected void afterAdd(Node<E> node) {
        super.afterAdd(node);
    }

    @Override
    protected void afterRemove() {
        super.afterRemove();
    }

}
