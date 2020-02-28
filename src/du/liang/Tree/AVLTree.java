package du.liang.Tree;

import java.util.Comparator;

public class AVLTree <E>extends BinarySearchTree<E> {

    private class AVLnode<E> extends Node {
        int height = 1;
        public AVLnode(Object element, Node parent) {
            super(element, parent);
        }
        public int balanceFactor(){
            int leftheight=left==null?0:((AVLnode<E>)left).height;
            int rightheight=right==null?0:((AVLnode<E>)right).height;
            return leftheight-rightheight;
        }
        public void updataHight(){
            int leftheight=left==null?0:((AVLnode<E>)left).height;
            int rightheight=right==null?0:((AVLnode<E>)right).height;
            this.height=Math.max(leftheight,rightheight)+1;
        }

        public AVLnode<E> tallerChild() {
            int leftheight=left==null?0:((AVLnode<E>)left).height;
            int rightheight=right==null?0:((AVLnode<E>)right).height;
            if(leftheight>rightheight){
                return (AVLnode<E>)this.left;
            }else if(leftheight<rightheight){
                return (AVLnode<E>)this.right;
            }else if(this.isLeftChild()){
                return (AVLnode<E>)this.left;
            }else return (AVLnode<E>)this.right;
        }
    }

    public AVLTree(){
        this(null);
    }
    public AVLTree(Comparator comparator) {
        super(comparator);
    }

    @Override
    protected void afterAdd(BinarySearchTree<E>.Node<E> node) {
        while ((node=node.parent)!=null){
            //node是否平衡
            if(isBalance((AVLnode<E>)node)){
                //更新高度
                updatahight(node);

            }else {
                //恢复平衡
                rebalance((AVLnode<E>)node);
                //已经恢复平衡
                break;
            }
        }
    }

    private void updatahight(Node node){
        ((AVLnode<E>)node).updataHight();
    }
    @Override
    protected Node<E> createNode(E element, Node parent) {
        return new AVLnode<>(element, parent);
    }
    private boolean isBalance(AVLnode<E> node){
        int b=node.balanceFactor();
        if (b==0||b==1||b==-1){
            return true;
        }
        return false;
    }

    private void rebalance(AVLnode<E> grand){
         AVLnode<E> parent=grand.tallerChild();
         AVLnode<E> node=parent.tallerChild();
         if(parent.isLeftChild()){//L
             if(node.isLeftChild()){
                 //LL
                 rotateRight(grand);

             }else {
                 //LR
                 rotateLeft(parent);
                 rotateRight(grand);
             }

         }else {//R
             if(node.isLeftChild()){
                 //RL
                 rotateRight(parent);
                 rotateLeft(grand);

             }else {
                 //RR
                 rotateLeft(grand);
             }
         }
    }
    private void rotateLeft(AVLnode node){
        AVLnode<E> g=node;
        AVLnode<E> p=(AVLnode<E>)node.right;
        AVLnode<E> child=(AVLnode<E>)p.left;
        g.right=p.left;
        p.left=g;
        //更新p的parent,让parent成为子树的根节点
        p.parent=g.parent;
        if(g.isLeftChild()){
            g.parent.left=p;
        }else if(g.isRightChild()){
            g.parent.right=p;
        }else {
            root=p;
        }
        //更新child的parent
        if(child!=null){
            child.parent=g;
        }
        //更新g的parent
        g.parent=p;

        //更新高度
        updatahight(g);
        updatahight(p);

    }
    private void rotateRight(AVLnode node){
        AVLnode<E> g=node;
        AVLnode<E> p=(AVLnode<E>)node.left;
        AVLnode<E> child=(AVLnode<E>)p.right;

        g.left=child;
        p.right=g;
        //更新p的parent,让parent成为子树的根节点
        p.parent=g.parent;
        if(g.isLeftChild()){
            g.parent.left=p;
        }else if(g.isRightChild()){
            g.parent.right=p;
        }else {
            root=g;
        }

        //更新child的parent
        if(child!=null){
            child.parent=g;
        }

        //更新g的parent
        g.parent=p;

        //更新高度
        updatahight(g);
        updatahight(p);


    }


}
