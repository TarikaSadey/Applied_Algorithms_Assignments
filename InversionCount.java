public class InversionCount {

    public static int[] count(int[] A) {
        int n = A.length;
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(A[i], i);
        }

        int[] count = new int[n];
        sort(items, 0, n - 1, count);
        int[] res = new int[n];

        for (int j=0; j<n; j++) {
            res[j] = count[j];
        }
        return res;

    }

    static void sort(Item[] items, int p, int r, int[] count) {
        if(p >= r) {
            return;
        }
        if (p < r) {
            int x = r - p;
            // Find the middle point
            int m = p + x/2;
            // Sort first and second halves
            sort(items, p, m, count);
            sort(items, m + 1, r, count);
            // Merge the sorted halves
            merge(items, p, m, m+1, r, count);
        }
    }

    static void merge(Item[] items, int p, int q, int r, int s, int[] count) {
        int m = s - p + 1;
        Item[] sorted = new Item[m];
        int rc = 0;
        int lp = p, hp = r;
        int index = 0;
        // Loop to store the count of smaller
        // Elements on right side when both
        // Array have some elements
        while (lp <= q && hp <= s) {
            if (items[lp].val > items[hp].val) {
                rc++;
                sorted[index++] = items[hp++];
            }
            else {
                count[items[lp].index] += rc;
                sorted[index++] = items[lp++];
            }
        }
        // Loop to store the count of smaller
        // elements in right side when only
        // left array have some element
        while (lp <= q) {
            count[items[lp].index] += rc;
            sorted[index++] = items[lp++];
        }
        // Loop to store the count of smaller
        // elements in right side when only
        // right array have some element
        while (hp <= s) {
            sorted[index++] = items[hp++];
        }
        System.arraycopy(sorted, 0, items, p, m);
    }
}

class Item {
    int val;
    int index;
    public Item(int val, int index)
    {
        this.val = val;
        this.index = index;
    }


public static void main(String[] args){
    InversionCount ic = new InversionCount();
    int[] a= {8,7,5,9,1,0};
    int[] k= ic.count(a);
    int l=k.length;
    for(int i=0;i<l;i++)
        System.out.println(k[i]);
}
}


