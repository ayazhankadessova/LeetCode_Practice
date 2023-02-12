class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        for idx, val in enumerate(nums):
            res = target - val
            if res in nums[idx + 1:]:
                return [idx, nums[idx + 1:].index(res) + (idx + 1)]



# class Solution:
#     def twoSum(self, nums: List[int], target: int) -> List[int]:
#         hashMap = {}
#         for i in range(len(nums)):
#             hashMap[i] = nums[i]
        
#         result = []
#         visited = []
#         values = list(hashMap.values())
#         for x in range(len(hashMap)):
#             visited.append(x)
#             res = target - hashMap[x]
#             if res in values[x+1:]:
#                 result.append(x)
#                 result.append(values[x+1:].index(res+x+1))
#                 if len(list(set(result))) ==2:
#                     break
                
#         #         if value == res:
#         #             result.append(x)
#         #             result.extend(key)
#         return result
                