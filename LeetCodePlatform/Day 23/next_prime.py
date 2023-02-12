import math
# Helper method
def is_prime(n: int):
    if n < 2:
        return False
    if n < 4:
        return True
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False
        return True

class Solution:

    #    # instance attributes
    # def __init__(self, name, age):
    #     self.num = number
        
    def next_prime(self, n: int) -> int:
        if n <= 1:
            return 2
            
        n += 1
        while True:
            if is_prime(n):
                return n
            n += 1


def main():
    p = Solution()
    print(p.next_prime(-10))
  
  
if __name__ == '__main__':
    main()