package du.liang.LinkedList;

public class LinkedList<E>  extends AbstractList<E>{

    private Node firstNode;
    private static class Node<E>{
        E elementE;
        Node next;

        public Node(E elementE, Node next) {
            this.elementE = elementE;
            this.next = next;
        }
    }

    /**
     * 清除所有元素
     */
    @Override
    public void clear() {
        size=0;
        firstNode = null;

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
        if (index==0){

            Node node= new Node<E>(element,firstNode);
            firstNode=node;
        }else {

            Node<E> previous= findNode(index-1);


            previous.next=new Node<E>(element,previous.next);

        }


        size++;
    }

    //找到index位置所对应的节点
    private Node<E> findNode(int index){
        rangeCheck(index);
        Node presentNode=firstNode;
        int n=0;
        while (n<index){
            if(presentNode.next!=null){
                presentNode=presentNode.next;
            }
            n++;
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
        Node<E> old=firstNode;
        if(index==0){

            firstNode=firstNode.next;
        }else {
            Node prev=findNode(index-1);
            old =prev.next;
            prev.next=prev.next.next;

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
            str.append(node.elementE);
            node=node.next;

        }
        str.append("]");
        return str.toString() ;
    }

}
