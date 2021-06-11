class Fibonacci:
    def fibonacci(self, n : int) -> int:
      a = 0
      b = 1
      if n<0:
        print("Incorrect input")
      elif n==0:
        return a
      elif n==1:
        return b
      else:
        for i in range(1,n):
          c = a + b
          a = b
          b = c
        return b

#print(Fibonacci.fibonacci(1,9))