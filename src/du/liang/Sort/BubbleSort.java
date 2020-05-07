package du.liang.Sort;

public class BubbleSort extends Sort{
    @Override
    protected void sort() {
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
}
