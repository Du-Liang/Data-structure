package du.liang.Sort;

import du.liang.Sort.tools.Asserts;
import du.liang.Sort.tools.Integers;

public class Main {
    public static void main(String[] args) {
        Sort s=new HeapSort();
        s.out();
        s.sort();
        s.out();
    }
}





/*
//import du.liang.Sort.tools.Times;
//import org.jetbrains.annotations.NotNull;

//Bubble Sort
public class Main {
    public static void main(String[] args) {
        Integer[] test= Integers.tailAscOrder(0,9,6);
//        Integer[] test2=Integers.copy(test);
//        Integer[] test3=Integers.copy(test);
//        Times.test("Bubble",()->{Bubble(test);});
//        Times.test("BubbleEnhance2",()->{BubbleEnhance2(test2);});
//        Times.test("BubbleEnhance3",()->{BubbleEnhance3(test3);});
//        for (int i:test
//             ) {
//            System.out.print(i+" ");
//        }
        selectionSort(test);
        Asserts.test(Integers.isAscOrder(test));

//        for (int i:test
//        ) {
//            System.out.print(i+" ");
//        }

    }

    //选择排序
    public static void selectionSort(Integer[] array){
        for (int end = array.length-1; end > 0; end--) {
            int maxIndex=0;
            for (int begin = 1; begin <=end  ; begin++) {
                if(array[maxIndex]<=array[begin]){       //
                    maxIndex=begin;
                }
            }
            int tem=array[maxIndex];
            array[maxIndex]=array[end];
            array[end]=tem;
        }
    }

//    冒泡排序
    public static void Bubble(Integer[] array){
        for (int end = array.length; end > 0; end--) {
            for (int begin = 1; begin <end  ; begin++) {
                if(array[begin-1]>array[begin]){
                    int tem=array[begin];
                    array[begin]=array[begin-1];
                    array[begin-1]=tem;
                }
            }
        }
    }
    public static void BubbleEnhance2( Integer[] array){
        for (int end = array.length; end > 0; end--) {
            boolean sorted=true;//是否已经有序
            for (int begin = 1; begin <end  ; begin++) {
                if(array[begin-1]>array[begin]){
                    int tem=array[begin];
                    array[begin]=array[begin-1];
                    array[begin-1]=tem;
                    sorted=false;
                }
            }
            if(sorted){
                break;
            }
        }
    }

    public static void BubbleEnhance3( Integer[] array){
        for (int end = array.length; end > 0; end--) {
            int LastSortIndex=0;//是否已经有序
            for (int begin = 1; begin <end  ; begin++) {
                if(array[begin-1]>array[begin]){
                    int tem=array[begin];
                    array[begin]=array[begin-1];
                    array[begin-1]=tem;
                    LastSortIndex=begin;
                }
            }
            end = LastSortIndex;
        }
    }


}
*/
