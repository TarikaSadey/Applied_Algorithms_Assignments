class MajorityElement:
    def majority(self, A):
        maj_index = 0
        count = 0
        count1 =0
        for i in range(len(A)):
            if A[maj_index] == A[i]:
                count += 1
            elif A[maj_index] != A[i]:
                count -= 1
            if count == 0:
                maj_index = i
                count = 1
        max_element=A[maj_index]
        for j in range(len(A)):
            if (A[j]==max_element):
                count1+=1

        if (count1>len(A)/2):
            return max_element
        else:
            return -1