package du.liang.Sort;

public class QuickSort extends Sort{
    @Override
    protected void sort() {
        sort(0,array.length);
    }

    /**
     * [begin,end)
     * @param begin
     * @param end
     */
    private void sort(int begin,int end){

         if (end-begin<2)return;

         //确定轴点的位索引
         int mid= pivotIndex(begin,end);
        //对子序列进行快速排序
        sort(begin,mid);
        sort(mid+1,end);
    }

    /**
     *
     * @param begin
     * @param end
     * @return
     */
    private int pivotIndex(int begin, int end){
        //随机选择一个元素跟begin交换
        swap(begin,begin+(int) Math.random()*(end-begin));
        //备份轴点元素
        Integer pivot=array[begin];
        boolean flag=true;
        //将end--,因为开始时是[begin,end)，减一后变成[begin,end]
        end--;
        while (begin<end){
            while (begin<end){
                if(array[end]>pivot){
                    end--;
                }else {
                    array[begin++]=array[end];
                    break;
                }
            }
            while (begin<end){
                if(array[begin]<=pivot){
                    begin++;
                }else {
                    array[end--]=array[begin];
                    break;
                }
            }
        }
        //将轴点元素放入最终的位置
        array[begin]=pivot;
        //返回轴点元素
        return begin;
    }
}
