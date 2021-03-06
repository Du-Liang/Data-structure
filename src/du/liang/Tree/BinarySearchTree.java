package du.liang.Tree;

import du.liang.Tree.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E> implements BinaryTreeInfo {
    private int size=0;
    protected Node<E> root;
    private Comparator<E> comparator;

    public BinarySearchTree(Node<E> root) {
        this.root = root;
    }

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
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>)node).element;
    }

    class Node<E> {
        E element;
        Node left;
        Node right;
        Node parent;
        public Node(E element, Node<E> parent){
            this.element=element;
            this.parent=parent;
        }
        public boolean isLeaf(){
            return left==null&&right==null;
        }
        public boolean hasTwoChildren(){
            return this.right!=null&&this.left!=null;
        }
        public boolean isLeftChild(){
            if(parent!=null&&this==this.parent.left){
                return true;
            }else
                return false;
        }

        public boolean isRightChild(){
            if(parent!=null&&this==this.parent.right){
                return true;
            }else
                return false;
        }
        public Node<E> sibling(){
            if(isLeftChild()) return parent.right;
            if(isRightChild()) return parent.left;
            return null;
        }
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size==0;
    }
    public void clear(){
        root=null;
        size=0;

    }
    public void add(E element){
        elementNotNullCheak(element);
        //添加第一个节点（根节点）
        if(root==null){
            root=createNode(element,null) ;
            size++;
            afterAdd(root);
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
                node.element=element;
                return;
            }
        }
        Node<E> newNode=createNode(element,parent);
        if(cmp>0){
            parent.right=newNode;
        }else {
            parent.left=newNode;
        }
        afterAdd(newNode);
        size++;
    }

    protected Node<E> createNode(E element,Node parent){
        return new Node<>(element,parent);
    }
/**
 *添加node之后的调整
 * node：新添加的节点
 */
    protected void afterAdd(Node<E> node){}
    /*
    * @return 返回值等于0：e1=e2，返回值大于0：e1>e2，
    * 返回值小于0：e1<e2。
    * */
    private int compare(E e1,E e2){
        if(comparator!=null){
            return comparator.compare(e1,e2);
        }else {
            return ((Comparable)e1).compareTo(e2);
        }
    }
    public void remove(E element){
        remove(node(element));
    }
    private void remove(Node node){
        if(node==null)return;
        size--;
        if(node.hasTwoChildren()){//度为2的节点
            Node s=successor(node);//找到后继节点
            node.element=s.element;//用后继节点覆盖度为2节点的值
            node=s;//后序只要删除node即可
        }
        //删除node节点（node节点的度必然为1或者0）
        Node<E> replacement = node.left!=null?node.left:node.right;
        if(replacement!=null){//表明要删除的节点是度为1的节点
            replacement.parent=node.parent;
            if(node.parent==null){
                root=replacement;
            }else if(node==node.parent.left){
                node.parent.left=replacement;
            }else {
                node.parent.right=replacement;
            }
            node=null;
        }else if(node.parent==null){//要删除的节点是根节点
            root=null;
        }else {//要删除的节点是叶子节点
            if(node==node.parent.left){
                node.parent.left=replacement;
            }else {
                node.parent.right=replacement;
            }
            node=null;

        }
//        if(node.left==null&&node.right==null){//度为0的节点
//            if(node==root){
//                node=null;
//            }else if(node==node.parent.left){
//                node.parent.left=null;
//            }else {
//                node.parent.right=null;
//            }
//        }else {//度为1的节点
//            if (node.left!=null){
//                Node child=node.left;
//
//            }else {
//                Node child=node.right;
//            }
//        }

    }

    protected void afterRemove(){

    }
    private Node<E> node(E element){//compare
        if(root==null)return null;
        Node node=root;
        while (node!=null){
            int cmp=compare(element,(E)node.element);
            if(cmp==0)return node;
            if(cmp>0)node=node.right;
            else node=node.left;
        }
        return null;
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
    public void PreorderTraversal(){
        PreorderTraversal(root);
    }
    private void PreorderTraversal(Node node){
        if(node==null)return;
        System.out.print(node.element+" ");
        PreorderTraversal(node.left);
        PreorderTraversal(node.right);
    }
    public void InorderTraversal(){
        InorderTraversal(root);
    }
    private void InorderTraversal(Node node){
        if(node==null)return;
        InorderTraversal(node.left);
        System.out.print(node.element+" ");
        InorderTraversal(node.right);
    }
    public void PostorderTraversal(){
        PostorderTraversal(root);
    }
    private void PostorderTraversal(Node node){
        if(node==null)return;
        PostorderTraversal(node.left);
        PostorderTraversal(node.right);
        System.out.print(node.element+" ");
    }
    public void LevelOrderTraversal(){
        LevelOrderTraversal(root);
    }
    private void LevelOrderTraversal(Node<E> root){
        if(root==null)return;
        Queue queue=new LinkedList<Node<E >>();
        Node<E> ahead;
        queue.offer(root);
        do {
            ahead=(Node) queue.poll();
            System.out.print(ahead.element+" ");
            if (ahead.left!=null)queue.offer(ahead.left);
            if (ahead.right!=null)queue.offer(ahead.right);
        }while (queue.peek()!=null);
    }
    public void LevelOrderTraversal(Visitor<E> visitor){
        LevelOrderTraversal(visitor,root);
    }
    private void LevelOrderTraversal(Visitor<E> visitor,Node<E> root){
        if(root==null||visitor==null)return;
        Queue queue=new LinkedList<Node<E >>();
        Node<E> ahead;
        queue.offer(root);
        boolean whetherend;
        do {
            ahead=(Node) queue.poll();
            //System.out.print(ahead.element+" ");
            whetherend=visitor.visit(ahead.element);
            if(whetherend)return;
            if (ahead.left!=null)queue.offer(ahead.left);
            if (ahead.right!=null)queue.offer(ahead.right);
        }while (queue.peek()!=null);
    }

    public void preorder(Visitor<E> visitor){
        if(root==null||visitor==null)return;
        preorder(visitor, root);
    }
    private void preorder(Visitor<E> visitor,Node<E> node){
        if(node==null||visitor.stop)return;
        visitor.stop=visitor.visit(node.element);
        preorder(visitor,node.left);
        preorder(visitor,node.right);
    }

    public void inorder(Visitor<E> visitor){
        if(root==null||visitor==null)return;
        inorder(visitor, root);
    }
    private void inorder(Visitor<E> visitor,Node<E> node){
        if(node==null||visitor.stop)return;
        inorder(visitor,node.left);
        if(visitor.stop)return;
        visitor.stop=visitor.visit(node.element);
        inorder(visitor,node.right);
    }

    public void postorder(Visitor<E> visitor){
         if(root==null||visitor==null)return;
        postorder(visitor, root);
    }
    boolean whetherend=false;
    private void postorder(Visitor<E> visitor,Node<E> node){
        if(node==null||visitor.stop)return;
        postorder(visitor,node.left);
        postorder(visitor,node.right);
        if (visitor.stop)return;
        visitor.stop=visitor.visit(node.element);
    }

    /**
     * @return true：结束遍历
     *          false :继续遍历
     * @param <E>
     */
    public static abstract class Visitor<E>{
        boolean stop;
        abstract boolean visit(E element);
    }

    public int height(){
        return height(root);
    }
    private int height(Node node){
        if(node==null)return 0;
        return Math.max(height(node.left),height(node.right))+1;
    }
//    层序遍历求高度
    public int height2(){
        if(root==null)return 0;
        int height=0;
        int nodenumber=1;
        Queue queue=new LinkedList<Node<E >>();
        Node<E> ahead;
        queue.offer(root);
        do {
            ahead=(Node) queue.poll();
            nodenumber--;
            if (ahead.left!=null)queue.offer(ahead.left);
            if (ahead.right!=null)queue.offer(ahead.right);
            if (nodenumber==0){//将要访问下一层
                height++;
                nodenumber=queue.size();
            }
        }while (queue.peek()!=null);
        return height;
    }
    public boolean isComplete2(){
        if(root==null)return false;
        Queue queue=new LinkedList<Node>();
        queue.offer(root);
        Node node;
        boolean leaf=false;
        while (queue.isEmpty()!=true){
            node=(Node) queue.poll();
//            do somthing
            if(leaf&&!node.isLeaf()) {
                return false;
            }
            if(node.hasTwoChildren()){
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if(node.left==null&&node.right!=null){
                return false;
            }
            if((node.left!=null&&node.right==null)||(node.left==null&&node.right==null)){
                //判断剩下的节点是不是叶节点
                leaf=true;
                if(node.left!=null){
                    queue.offer(node.left);
                }

            }
        }
        return true;
    }
    public boolean isComplete(){
        if(root==null){
            return false;
        }
        Queue queue=new LinkedList<Node>();
        queue.offer(root);
        Node node;
        boolean isleaf=false;
        while (!queue.isEmpty()){
            node=(Node) queue.poll();
            if(isleaf&&node.left!=null){
                return false;
            }
            if(node.left!=null){
                queue.offer(node.left);
            }else if(node.right!=null){
                 return false;
            }
            if(node.right!=null){
                queue.offer(node.right);
            }else {
                isleaf=true;
            }
        }
        return true;
    }
    public BinarySearchTree invertTree(){
        return invertTree(root);
    }
     private BinarySearchTree invertTree(Node root) {
        if(root==null)return null;
         invertTree(root.left);
         invertTree(root.right);
         Node tem=root.left;
         root.left=root.right;
         root.right=tem;
         return new BinarySearchTree(root);
    }
    private Node predecessor(Node node){
        if(node==null)return null;
        if(node.left!=null){
            node=node.left;
            while (node.right!=null){
                node=node.right;
            }
            return node;
        }else {
            while (node.parent!=null&&node==node.parent.left){
                node=node.parent;
            }
            return node.parent;
        }
    }
    private Node successor(Node node){
        if(node==null)return null;
        if(node.right!=null){
            node=node.right;
            while (node.left!=null){
                node=node.left;
            }
            return node;
        }else {
            while (node.parent!=null&&node==node.parent.right){
                node=node.parent;
            }
            return node.parent;
        }
    }


}
