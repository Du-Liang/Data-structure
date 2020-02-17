package du.liang.Stack;
//栈

import java.util.ArrayList;

public class Stack <E>{
    private int size=-1;
    private ArrayList<E> array;
    Stack(){
        array=new ArrayList<E>();
    }
    boolean isEmpty(){
        return size==0;
    }
    public void push(E element){
        size++;
        array.add(size,element);
    }
    E pop(){
        return array.get(size--);
    }
    E top(){
        return array.get(size);
    }
}
