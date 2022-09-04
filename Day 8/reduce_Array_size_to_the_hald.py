class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        """
        1) find out half length of arr 
        2) create a dict with {val : num occur} for values in arr
        3) sort dict by increasing order of num occur
        4) keep choosing top number until the sum is at least half
        
        """
        
        # TC: O(k*log(k)) where k is the number of unique chars in arr
        # SC: O(k) where k is the number of unique chars in arr
        
        half = len(arr) / 2
        
        num_occur = {}
        for elem in arr:
            if elem in num_occur:
                num_occur[elem]+=1
            else:
                num_occur[elem] = 1
        # to be able to start from largest number of occurences
        sort_values = sorted(num_occur.values(), reverse=True)
        
        total = count = 0
        for elem in sort_values:
            # add them till reach at least half of the arr
            total+=elem
            # count numer of "elems"
            count+=1
            if total >= half:
                return count
            
        
        # import itertools

        # stuff = list(set(arr))
        # if len(stuff) ==1:
            # return 1
        
        # for L in range(0, len(stuff)+1):
            # for subset in itertools.combinations(stuff, L):
                # if len(subset) < 1:
                   #  pass
                # else:
                    # for x in subset:
                       # arr = list(filter(lambda a: a != x, arr))
                        #print(arr)
                    # if len(arr) * 2 > len(arr):
                        # print(subset)
                        # return len(subset) 
                        
      
        # total_count = 0
        
        # for index, count in enumerate(sorted(collections.Counter(arr).values(), reverse=True)):
            # total_count += count
            
            # if total_count >= len(arr) // 2:
                # return index + 1
        
        # return 0 