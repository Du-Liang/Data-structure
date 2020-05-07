package du.liang.Sort;

public class SelectionSort extends Sort {
    @Override
    protected void sort() {
        for (int end = array.length-1; end >0; end--) {
            int maxindex=0;
            for (int begin = 1; begin <= end; begin++) {
                if(cmp(maxindex,begin)<=0)maxindex=begin;
            }
            swap(end,maxindex);
        }
    }


}
