package du.liang.linearlist;

import java.util.Arrays;

public class ArrayList {
    //元素的数量
    private int size;
    //所有元素
    private int[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND= -1;
    private  int capacity;

    public ArrayList(int capacity) {
        if(capacity<DEFAULT_CAPACITY){
            capacity=DEFAULT_CAPACITY;
        }
        elements=new int[capacity];
        this.capacity=DEFAULT_CAPACITY;

    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public void clear() {
        size = 0;
    }

    /**
     * 元素的数量
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(int element) {
        boolean whetherIn=false;
        for (int i:
             elements) {
            if (element==i){
                whetherIn=true;
                break;
            }
        }
        return whetherIn;
    }

    /**
     * 添加元素到尾部
     * @param element
     */
    public void add(int element) {
        add(size,element);

    }

    /**
     * 在index位置插入一个元素
     * @param index
     * @param element
     */
    public void add(int index, int element) {
        RangeChakeforAdd(index);
        if(size<capacity){
            for (int i = size; i >index; i--) {
                elements[i]=elements[i-1];
            }
            elements[index]=element;
            size++;
        }else {
            capacity+=DEFAULT_CAPACITY;
            int[] oldArray=elements;
            elements = new int[capacity];
            for (int i = 0; i < oldArray.length; i++) {
                elements[i]=oldArray[i];
            }
            add(index,element);

        }

    }
    /**
    * 检查索引是否合法
    *
    * */
    private void RangeChakeforAdd(int index){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("index:"+index+" size:"+size);
        }
    }

    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    public int get(int index) {
        if(0<=index&&index<size){
            return elements[index];

        }else {
            throw new IndexOutOfBoundsException("idex is "
                    +index+" but size is "+size
            );
        }

    }

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    public int set(int index, int element) {
        int result;
        if(0<=index&&index<size){
            result = elements[index];
            elements[index]=element;

        }else {
            throw new IndexOutOfBoundsException("idex is "
                    +index+" but size is "+size
            );
        }
        return result;
    }



    /**
     * 删除index位置的元素
     * @param index
     * @return
     */
    public int remove(int index) {
        int result=0;
        if(size<DEFAULT_CAPACITY){
            result=elements[index];
            for (int i = index; i <size-1 ; i++) {
                elements[i]=elements[i+1];
            }
            --size;
        }else {
            throw new IndexOutOfBoundsException("size "+size+" index "+index);
        }

        return result;
    }

    /**
     * 查看元素的索引
     * @param element
     * @return
     */
    public int indexOf(int element) {
        int indexOfElement=ELEMENT_NOT_FOUND;
        for(int i:
             elements) {
            indexOfElement++;
            if(i==element){
                break;
            }
        }
        return indexOfElement;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append("size="+size+" [");

        for (int i = 0; i < size; i++) {
            if(i!=0){
                str.append(",");
            }
            str.append(elements[i]);

        }
        str.append("]");
        return str.toString() ;
    }
}
