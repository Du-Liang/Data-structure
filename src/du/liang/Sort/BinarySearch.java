package du.liang.Sort;

public class BinarySearch {
    public static int indexof(Integer[] array,int target){
        if(array==null||array.length==0) return -1;
        int begin=0;
        int end=array.length;
        int mid=(begin+end)>>2;
        while (begin<end){
            if (array[mid]==target) break;
            else if(array[mid]<target){
                begin=mid+1;
            }else {
                end=mid;
            }
            mid=(begin+end)>>1;
            //System.out.println("mid="+mid);
        }
        if(begin<end) return mid;
        else return -1;
    }
}
