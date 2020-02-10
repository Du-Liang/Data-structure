package du.liang.LinkedList;
//双向循环链表
public class CircleLinkedList<E>  extends AbstractList<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    //Josephus Problem
    Node current ;
    public void reset(){
        current=firstNode;
    }
    public E next(){
        if (current==null) return null;
        E result= (E) current.elementE;
        current=current.next;
        return result;
    }
    E kill(){
        if (current==null) return null;
        E result= (E) current.elementE;
        int index=0;
        Node x=firstNode;
        while (x!=current){
            index++;
            x=x.next;
        }
        current=current.next;
        this.remove(index);
        return result;
    }
    private static class Node<E>{
        E elementE;
        Node<E> prev;
        Node<E> next;

        public Node(E elementE, Node<E> prev,Node<E> next) {
            this.elementE = elementE;
            this.prev= prev;
            this.next = next;

        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
//            if(prev!=null){
//                sb.append(prev.elementE);
//            }else {
//                sb.append("null");
//            }
//            sb.append("_").append(elementE).append("_");
//            if(next!=null){
//                sb.append(next.elementE);
//            }else {
//                sb.append("null");
//            }
            sb.append(elementE);
            return sb.toString();
        }
    }

    /**
     * 清除所有元素
     */
    @Override
    public void clear() {
        size=0;
        firstNode = null;
        lastNode = null;

    }

    /**
     * 元素的数量
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * 是否包含某个元素
     *
     * @param element
     * @return
     */
    @Override
    public boolean contains(Object element) {
        return indexOf(element)!=ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到尾部
     *
     * @param element
     */
    @Override
    public void add(E element) {

        add(size,element);

    }

    /**
     * 获取index位置的元素
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return findNode(index).elementE;
    }

    /**
     * 设置index位置的元素
     *
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    @Override
    public E set(int index, E element) {
        Node<E> old,node=findNode(index);
        old=node;
        node.elementE=element;
        return old.elementE;
    }

    /**
     * 在index位置插入一个元素
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
//        往最后面添加元素
        if(index==size){
            Node oldlast=lastNode;
            lastNode=new Node<>(element,lastNode,firstNode);
            if(oldlast==null){//添加第一个节点
                firstNode=lastNode;
                firstNode.prev=firstNode;
                firstNode.next=firstNode;

            }else{
                oldlast.next=lastNode;
                firstNode.prev=lastNode;
            }

        }else {//往头部添加节点
            Node<E> NextNode= findNode(index);
            Node<E> PrevNode=NextNode.prev;
            Node<E> NewNode=new Node<>(element,PrevNode,NextNode);
            NextNode.prev=NewNode;
            PrevNode.next=NextNode;

            if (index==0){
                firstNode=NewNode;
            }
        }
        size++;
    }

    //找到index位置所对应的节点
    private Node<E> findNode(int index){
        rangeCheckForAdd(index);
        Node presentNode;
        if(index<(size>>1)){
            int n=0;
            presentNode=firstNode;
            while (n<index){
                if(presentNode.next!=null){
                    presentNode=presentNode.next;
                }
                n++;
            }
        }else {
            int n=size-1;
            presentNode=lastNode;
            while (n>index){
                if(presentNode.prev!=null){
                    presentNode=presentNode.prev;
                }
                n--;
            }

        }

        return presentNode;
    }

    /**
     * 删除index位置的元素
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> old = findNode(index);
        if(size==1){
            firstNode=null;
            lastNode=null;
        }else {
            Node prev = old.prev;
            Node next = old.next;
            if (index == 0) {
                firstNode = next;

            } else {
                prev.next = next;
            }
            if (index == size - 1) {//index==size-1
                lastNode = prev;


            } else {
                next.prev = prev;
            }
        }
        size--;
        return old.elementE;
    }

    /**
     * 查看元素的索引
     *
     * @param element
     * @return
     */
    @Override
    public int indexOf(Object element) {
        int indexOfElement=ELEMENT_NOT_FOUND;
        int i=0;
        Node<E> node=firstNode;
        if(element==null){
            while (node!=null){
                if(node.elementE==null){
                    indexOfElement=i;
                    break;
                }
                i++;
                node=node.next;
            }
        }else {
            while (node!=null){
                if(node.elementE.equals(element)){
                    indexOfElement=i;
                    break;
                }
                i++;
                node=node.next;
            }
        }

        return indexOfElement;

    }
    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append("size="+size+" [");
        Node<E> node=firstNode;

        for (int i = 0; i < size; i++) {
            if(i!=0){
                str.append(",");
            }
            str.append(node);
//            str.append(" next=");
//            str.append(node.next);
            node=node.next;

        }
        str.append("]");
        return str.toString() ;
    }

}
