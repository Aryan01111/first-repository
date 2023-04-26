public class Radix {

    static void sortCount(int[] a, int place){
        int[] freq = new int[10]; // bcoz hum digit by digit lete h aur koi bhi digit 9 se badi ni hoti
        int n = a.length;
        int[] output = new int[n];
        for(int i =0;i<a.length;i++){
            freq[(a[i]/place)%10] ++;
        } 
        for(int i =1;i<freq.length;i++){
            freq[i] += freq[i-1];
        }
        for(int i = n-1;i>=0;i--){
            int idx = freq[(a[i]/place)%10] - 1;
            output[idx] = a[i];
            freq[(a[i]/place)%10]--;
        }
        for(int i =0;i<a.length;i++){
            a[i] = output[i];
        }
    }

    static int findMax(int[] a){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<a.length;i++){
            if(a[i]>max) max = a[i];
        }
        return max;
    }

    static void radix(int[] a){
        int max = findMax(a);
        for(int place =1;max/place>0;place *=10){
            sortCount(a, place);
        }
    }
    public static void main(String[] args) {
        int [] a = {43,453,626,894,0,3};
        radix(a);
        for(int i :a){
            System.out.print(i+" ");
        }
    }
}
