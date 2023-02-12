# Approach:
# 1. Iterate through an array of integers nums1
# 2. Keep track for occurence of every number using hashMap called counter

# -> Alternatively, we could use a Collections.counter built-in function of nums1 as follows: collections.Counter(nums1)

# 3. Iterate through an array of inetegers nums2
# 4. If number in nums2 is present in nums1 and its value is more than 0 (occurence more than 0), add to results array and decrement its value (occurence) in hashMap
# 5. return results array

# TC: O(N + m) - whichever array is longer
# SC: O(m) - based on results array

# Big (O) = Statement 1 + Statement 2
        # = Complexity of Loop 1 + Complexity of Loop 2
        # = n + n
        # = 2n (ignore the constant)
        # = O(n) -> consider only higher term

        
# I tried implementing a different version with linear complexity, which:
# 1. Iterates through nums1
# 2. If number in nums2, it leaves that number in nums1, removes from nums2
# 3. If not, it pops it from left from nums1
# 4. returns nums1

# Problem, the iteration process is tricky because if we use for loop with indexing, when I pop numbers from nums1, it messes up. Tried to use while & stuff, but still no luck. will think ab it :)
    

class Solution(object):
    def intersect(self, nums1, nums2):
        
        counter = {}
        result = []
        for number in nums1:
            if number in counter:
                counter[number] +=1
            else:
                counter[number] = 1   

        for num in nums2:
            if num in counter:
                if counter[num] > 0:
                    counter[num] -= 1
                    result.append(num)
                
        return result

p = Solution()
print(p.intersect([1,2,2,1], [2,2]))
print(p.intersect([4,9,5], [9,4,9,8,4]))