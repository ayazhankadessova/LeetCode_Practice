class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        results = []
        HashMap = {}
        
        if len(list1) > len(list2):
            for i in range(len(list1)):
                for x in range(len(list2)):
                    if list1[i] == list2[x]:
                        HashMap[list1[i]] = i+x
        else:
            for i in range(len(list2)):
                for x in range(len(list1)):
                    if list2[i] == list1[x]:
                        HashMap[list2[i]] = i+x
                        
        min_value = min(HashMap.values())
        # print(min(HashMap.values()))
        
        for key, value in HashMap.items():
            if min_value == value:
                results.append(key)
                
        return results
    
    
#     class Solution:
#     def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
#         dic = {}
#         for index, val in enumerate(list1):
#             dic[val] = index
#         result = []
#         lowest = 2000
#         for index,val in enumerate(list2):
#             index2 = dic.get(val, -1)
#             if index2>=0:
#                 if index + index2 < lowest:
#                     lowest = index+index2
#                     result = [val]
#                 elif index + index2 == lowest:
#                     result.append(val)
#         return result