class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        created_set = set()
        
        for i in range(30):
            # number to the power of two
            string = str(2**i)
            
            string = "".join(sorted(string)) #1, 2, 4,8, 16 ...
            created_set.add(string)
        
        # set() method is used to convert any of the iterable to sequence of iterable elements with distinct elements, commonly called Set
        return "".join(sorted(str(n))) in created_set

        