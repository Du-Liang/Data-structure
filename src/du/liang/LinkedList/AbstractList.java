package du.liang.LinkedList;

public abstract class AbstractList <E> implements List<E>{
    protected int size;

    protected void rangeCheck(int index){
        if(index>size){
            throw new IndexOutOfBoundsException("size: "+size+" but" +
                    " index:"+index);
        }
    }

}
