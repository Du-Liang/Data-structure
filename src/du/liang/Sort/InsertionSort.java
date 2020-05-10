package du.liang.Sort;

public class InsertionSort extends Sort {
    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int current=begin;
            while (current>0&&cmp(current, current - 1) < 0) {
                    swap(current, current - 1);
                current--;
            }
        }
    System.out.println("this is InsertionSort");
    }
}
