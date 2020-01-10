package du.liang.LinkedList;

public abstract class AbstractList <E> implements List<E>{
    protected int size=0;

    protected void rangeCheck(int index){
        if(index>size){
            throw new IndexOutOfBoundsException("size: "+size+" but" +
                    " index:"+index);
        }
    }

}
