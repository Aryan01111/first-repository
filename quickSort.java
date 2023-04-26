public class quickSort{

    static void swap(int [] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    static int partition(int[] a,int start, int end){
        int pivot = a[start];
        int count =0;
        for(int i =start+1;i<=end;i++){
            if(a[i]<=pivot) count++;
        }
        int pivotIndex = start+count;
        swap(a, start, pivotIndex);
        int i = start, j = end;
        while(i<pivotIndex && j>pivotIndex){
            while(a[i]<=pivot) i++;
            while(a[j]>pivot) j--;
            if(a[i]<pivot && a[j]>pivot){
                swap(a,i,j);
            }
        }
        return pivotIndex;
    }
    
    static void sort(int[] a, int start,int end){
        if(start>=end) return;
        int pi = partition(a,start,end);
        sort(a, start, pi-1);
        sort(a, pi+1, end);
    }
    public static void main(String[] args){
        int a[] = {6,3,1,5,4};
        int n = a.length;
        sort(a,0,n-1);
        for(int val:a){
            System.out.print(val+" ");
        }
    }   
} 