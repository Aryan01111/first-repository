public class Merge_sort{
    static void merge(int[] a,int l, int r,int mid){
        int n1 = mid+1-l;
        int n2 = r- mid;       
        int left[] = new int[n1];
        int right[] = new int[n2];
        int i,j,k;
        for(i=0;i<n1;i++) left[i] = a[l+i];
        for(j=0;j<n2;j++) right[j] = a[mid+1+j];
        i=0;j=0;k=l;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                a[k++] = left[i++];
            }else{
                a[k++] = right[j++];
            }
        }
        while(i<n1) a[k++]= left[i++];
        while(j<n2) a[k++]= right[j++];
        
    }

    static void mergesort(int[] a,int l, int r){
        if(l>=r) return;
        int mid= (l+r)/2;
        mergesort(a,l,mid);
        mergesort(a,mid+1,r);
        merge(a,l,r,mid);
    }
    public static void main(String[] args) {
        int[] a = {7,20,4,11,8,2};
        int n = a.length;
        mergesort(a,0,n-1);
        for(int val:a){
            System.out.print(val+" ");
        }
    }
}