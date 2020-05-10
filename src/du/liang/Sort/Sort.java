package du.liang.Sort;

public abstract class Sort {
    protected Integer[] array={3,6,8,9,54,2,0,0,-6,99};
    private int cmpCount=0;
    private int swapCount=0;
    public void sort(Integer[] array){
        if(array==null||array.length<2) return;

        this.array=array;
        sort();
    }

    protected abstract void sort();

    /*
    * 0   ==
    * >0 array[i1]>array[i2]
    * <0 array[i1]<array[i2]
    * */
    protected int cmp(int i1,int i2){
        cmpCount++;
        return array[i1]-array[i2];
    }
    protected void swap(int i1,int i2){
        Integer tem;
        swapCount++;
        tem=array[i1];array[i1]=array[i2];array[i2]=tem;
    }
    public Integer[] out(){
        for (int i:array
             ) {
            System.out.print(i+"\t");
        }
        System.out.println();
        return array;
    }
}
