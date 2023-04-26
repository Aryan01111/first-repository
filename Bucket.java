import java.util.*;
public class Bucket {

    static void bucketSort(float[] a){
        int n = a.length;
        // creating bukcets
        // int a = new int[5]; similarly we'll make arraylist below
        ArrayList<Float>[] buckets = new ArrayList[n]; // for creating buckets

        //bucket is a 2-d array type of structure bcoz in every bucket we are storing more than one value
        //in arraylist we make ArrayList<Float> list but in above we used "[]" to make make arraylist of array
        //We often come across 2D arrays where most of the part in the array is empty. Since space is a huge problem, we try different things to reduce the space. One such solution is to use jagged array when we know the length of each row in the array, but the problem arises when we do not specifically know the length of each of the rows. Here we use ArrayList since the length is unknown.
        
        for(int i =0;i<n;i++){ // for empty buckets in 2-d fashion.
            buckets[i] = new ArrayList<Float>();
        }
        for(int i =0;i<n;i++){
            int bucketIndex = (int) a[i]*n; //this is a float value so we have to cast it into integer     
                                            //above i can't write (int)n*a[i] coz a[i] needs to be converted so (int)a[i]*n;
            buckets[bucketIndex].add(a[i]);
        }
        for(int i =0;i<buckets.length;i++){ 
            Collections.sort(buckets[i]);
        }
        int idx =0;
        for(int i = 0;i<buckets.length;i++){
            ArrayList<Float> currBucket = buckets[i];
            for(int j =0;j<currBucket.size();j++){
                a[idx++] = currBucket.get(j);  
            }
        }

    }
    public static void main(String[] args) {
        float[] a = {0.5f,0.4f,0.3f,0.2f,0.1f};
        bucketSort(a);
        for(float f: a){
            System.out.print(f+" ");
        }
    }
}
