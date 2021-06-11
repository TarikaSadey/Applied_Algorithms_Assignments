import static org.junit.Assert.*;

public class InsertionSort {
    static void sort(int A[]) {
        int n=A.length;
        int i;
        for(i=1;i<n;i++)
        {
            int v = A[i];
            int gap = i-1;
            assertTrue(sorted(A,0,i-1));
            while(gap>=0 && A[gap] > v)
            {
                assertFalse(A[gap] == v);
                A[gap+1]= A[gap];
                gap=gap-1;
            }
            A[gap+1]=v;
        }
    }

    static Boolean sorted(int A[], int begin, int end) {
        for (int i = begin; i != end; ++i) {
            if (i + 1 != end) {
                if (A[i] > A[i+1]) return false;
            }
        }
        return true;
    }
}