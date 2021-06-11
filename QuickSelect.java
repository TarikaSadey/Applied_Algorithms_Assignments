public class QuickSelect {
    static int select(int[] A, int k) {
        int l=0;
        int r=A.length-1;
        int res=kthSmallest(A,l,r,k+1);
        return res;
    }

    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        // If k is smaller than number of elements
        // in array
        if (k > 0 && k <= r - l + 1) {
            // Partition the array around last
            // element and get position of pivot
            // element in sorted array
            int pos = partition(arr, l, r);

            // If position is same as k
            if (pos - l == k - 1)
                return arr[pos];

            // If position is more, recur for
            // left subarray
            if (pos - l > k - 1)
                return kthSmallest(arr, l, pos - 1, k);

            // Else recur for right subarray
            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }

        // If k is more than number of elements
        // in array
        return Integer.MAX_VALUE;
    }



    static int partition(int[] A, int lo, int hi) {
        if(hi==A.length)
            hi=hi-1;
        int x = A[hi], i = lo;
        for (int j = lo; j <= hi - 1; j++) {
            if (A[j] <= x) {
                // Swapping arr[i] and arr[j]
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;

                i++;
            }
        }

        // Swapping arr[i] and arr[r]
        int temp = A[i];
        A[i] = A[hi];
        A[hi] = temp;

        return i;
    }

    public static int med5(int[] arr, int start, int end){
        if(start==end)return arr[start];
        //sort elements
        for(int i=end;i>start;i--){
            for(int j=start+1;j<=end;j++){
                if(arr[j-1]>arr[j])
                    swap(arr,j,j-1);
            }
        }
        //return median
        return arr[start+((end-start+1)>>1)];
    }

    //get value for median of median
    public static int getMedianOfMedian(int[] arr, int start, int end){
        int n=end-start+1;
        if(n<=5) return med5(arr,start,end);//less than 5 elements
        int numOfGroups = n/5 + (n%5==0?0:1);

        //below medians array is allocated on each recurrsive call
        //can be minimized by passing it from client and reusing
        int[] medians = new int[numOfGroups];//one median for each subgroup

        for(int i=0;i<numOfGroups;i++){
            int groupStart=i*5;
            int groupEnd = Math.min(arr.length-1, i*5+5-1);//last group can have less than 5 elements
            medians[i]=med5(arr,groupStart,groupEnd);
        }
        return getMedianOfMedian(medians,0,medians.length-1);
    }

    private static void swap(int[] arr, int index1, int index2){
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
}
