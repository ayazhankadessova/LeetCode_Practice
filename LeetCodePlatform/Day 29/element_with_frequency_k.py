from array import array


class Solution:
    def element_with_k_frequency(self, arr: array, k: int) -> int:
        hashMap = {}
        for number in arr:
            if number in hashMap:
                hashMap[number] += 1
            else: 
                hashMap[number] = 1
        
        for key, value in hashMap.items():
            if value == k:
                return key
    
p = Solution()
print(p.element_with_k_frequency([1, 2, 3, 2, 1, 2, 3, 2, 1], 2))

# Time Complexity: O(n)
# Space Complexity: O(n)
