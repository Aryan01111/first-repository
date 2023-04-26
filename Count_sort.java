public class Count_sort{
    
    static int findMax(int[] a){
        int n = a.length;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            if(a[i]>max) max = a[i];
        }
        return max;
    }
    
    static void sort(int []a){
        int max = findMax(a);
        int freq[] = new int[max+1];// frequency array
        
        for(int i =0;i<a.length;i++){
            freq[a[i]]++;
        }
        for(int i = 1;i<freq.length;i++){
            freq[i]+= freq[i-1];
        }
        int[] output = new int[a.length];
        for(int i = a.length-1;i>=0;i--){
            int idx = freq[a[i]]-1;
            output[idx] = a[i];
            freq[a[i]]--;
        }
        for(int i =0;i<a.length;i++){
            a[i] = output[i];
        }
    }
    public static void main(String[] args) {
        int [] a = {1,4,5,2,2,5};
        sort(a);
        for(int val: a){
            System.out.print(val +" ");
        }

    }
}
