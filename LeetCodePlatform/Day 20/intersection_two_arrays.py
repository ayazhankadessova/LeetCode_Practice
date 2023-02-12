class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # Approach:
        # Intersection of two lists
        # TC: O(N)
        # SC: O(1)
        return list(set(nums1) & set(nums2))
        
        
        # Appraoch 2:
        # created a new array to collect items that are in both
        # make set
        # TC: O(N)
        # SC: O(N)
        # created = [x for x in nums1 if x in nums2]
        # return set(created)