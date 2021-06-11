import java.util.*;

public class QuickSort {
    static void Random(int A[],int p,int r)
    {
        Random rand = new Random();
        int pivot = rand.nextInt(r-p)+p;
        int t = A[pivot];
        A[pivot] = A[r];
        A[r] = t;
    }

    static int partition(int A[], int p, int r) {
        int pivot;
        if (A.length == 1)
        {
            pivot = A[0];
        }
        else {
            Random(A,p,r);
        }
        pivot= A[r];
        int i= p-1;
        for(int j=p; j<r; j++)
        {
            if (A[j] < pivot)
            {
                i=i+1;
                int x = A[i];
                A[i] = A[j];
                A[j] = x;
            }
        }
        int y = A[i+1];
        A[i+1] = A[r];
        A[r] = y;
        return i+1;
    }

    static void sort(int A[], int p, int r) {
        if (A.length == r) {
            r -= 1;
        }
        if(p<r)
        {
            int q = partition(A,p,r);
            sort(A,p,q-1);
            sort(A,q+1,r);
        }
    }

}
