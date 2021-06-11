public class BinarySearch {
    static int search(int A[], int key) {
        int n = A.length-1;
        int x = 0;
        while(x <= n)
        {
            int mid = x + (n-x)/2;
            if (A[mid] == key)
                return mid;
            if (A[mid] <key)
                x = mid + 1;
            else
                n = mid - 1;
        }
        return -1;
    }
}
