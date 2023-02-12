class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        
        # last index of nums 1, start filling from the end 
        last = m + n -1
        
        # merge in reverse order
        while m > 0 and n >0:
            if nums1[m-1] >= nums2[n-1]:
                nums1[last] = nums1[m-1]
                m -=1
            else:
                nums1[last] = nums2[n-1]
            last -= 1
            
            # if anything is left in nums2, put it in nums1
            while n >0:
                nums1[last] = nums2[n-1]
                n-=1
                last-=1

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        
        # last index of nums 1, start filling from the end
        pointer = len(nums1) - 1

        # nums1's last index w/ number
        m = m - 1

        # nums2's last index w/ number
        n = n - 1
        
        # merge in reverse order
        while m >= 0 and n >= 0:

            # the bigger replaces the latest pointer index in nums1 
            if nums1[m] >= nums2[n]:

                nums1[pointer] = nums1[m]

                # move left
                m -= 1
            else:
                nums1[pointer] = nums2[n]
                n -= 1
                
            pointer -= 1

        # if there is anything left in nums2, replace nums1 with that    
        if n >= 0:
            nums1[:n+1] = nums2[:n+1]