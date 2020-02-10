package du.liang.Stack;
//栈

import java.util.ArrayList;

public class Stack <E>{
    private int size=0;
    private ArrayList<E> array=new ArrayList<E>(10);
//    Stack(){
//        array=new ArrayList<E>(10);
//    }
    boolean isEmpty(){
        return size==0;
    }
    public void push(E element){
        array.add(size,element);
        size++;
    }
    E pop(){
        return array.get(size--);
    }
    E top(){
        return array.get(size);
    }
}
