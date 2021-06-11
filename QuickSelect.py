class QuickSelect:
    def select(self, A: [int], k: int) -> int:

        if len(A)>0:
            low_list=[]
            high_list=[]
            pivot1 = self.partition(A, 0, len(A))
            for i in (A):
                if (i>pivot1):
                    high_list.append(i)
                elif (i<pivot1):
                    low_list.append(i)
            piv_ind=len(low_list)
            if (piv_ind==k):
                return pivot1
            elif (piv_ind>k):
                return self.select(low_list,k)
            else:
                return self.select(high_list,k-piv_ind-1)

    def partition(self, A: [int], lo: int, hi: int) -> int:
        median_list = []
        for i in range(lo, hi, 5):
            sub = A[i:i + 5]
            sub.sort()
            median_list.append(sub[len(sub) // 2])

        print(median_list)
        if len(median_list)<=5:
            pivot = median_list[len(median_list) // 2]
            return pivot
        else:
            return self.partition(median_list,0,len(median_list))