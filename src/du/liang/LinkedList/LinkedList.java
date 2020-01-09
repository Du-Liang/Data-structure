package du.liang.LinkedList;

public class LinkedList<E> implements List<E>{
    private int size;
    private Node<E> firstNode;
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
    public void add(Object element) {

    }

    /**
     * 获取index位置的元素
     *
     * @param index
     * @return
     */
    @Override
    public Object get(int index) {
        return null;
    }

    /**
     * 设置index位置的元素
     *
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    @Override
    public Object set(int index, Object element) {
        return null;
    }

    /**
     * 在index位置插入一个元素
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, Object element) {

    }

    /**
     * 删除index位置的元素
     *
     * @param index
     * @return
     */
    @Override
    public Object remove(int index) {
        return null;
    }

    /**
     * 查看元素的索引
     *
     * @param element
     * @return
     */
    @Override
    public int indexOf(Object element) {
        return 0;
    }
}
