import math
class MakingChange:
    def minimumCoins(self, money, coins):
        arr = [0]*(money+1)
        for i in range(1,money+1):
            minimum = math.inf
            for j in range(0,len(coins)):
                if(i >= coins[j]):
                    minimum = min(minimum,1+arr[i-coins[j]])
                    #print(minimum)
            arr[i] = minimum
        #print(arr)
        result = arr[money]
        if result<math.inf:
            return result
        return -1