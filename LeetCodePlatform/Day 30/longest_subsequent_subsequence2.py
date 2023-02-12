# Approach: 
# 1. Create a Priority Queue to store the element
# 2. Store the first element in a variable
# 3. Remove it from the Priority Queue
# 4. Check the difference between this removed first element and the new peek element
# 5. If the difference is equal to 1 increase the count by 1 and repeats step 2 and step 3
# 6. If the difference is greater than 1 set counter to 1 and repeat step 2 and step 3
# if the difference is equal to 0 repeat step 2 and 3
# if counter greater than the previous maximum then store counter to maximum
# 7. Continue step 4 to 7 until we reach the end of the Priority Queue
# 8. Return the maximum value


# Time Complexity: O(N*log(N)), Time required to push and pop N elements is logN for each element.
# Auxiliary Space: O(N), Space required by priority queue to store N elements.

import array
import bisect


class Solution:
    def longest_subsequence(self, arr: array) -> int:
        pq = []
        for i in range(len(arr)):
    
            # adding element from
            # array to PriorityQueue
            bisect.insort(pq, arr[i])
        
        prev = pq[0]
        pq.pop(0)

        counter = 1
        longest = 1

        while (len(pq)):
            # not consecutive
            if (pq[0] - prev > 1):
                counter = 1
                prev = pq[0]
                pq.pop(0)
            # check for duplicates/if prev & curr elements are same
            elif (pq[0] - prev == 0):
                prev = pq[0]
                pq.pop(0)
            # consecutive
            else:
                counter +=1
                prev = pq[0]
                pq.pop(0)

            # Check if current longest
            # subsequence is the greatest
            if(longest < counter):
                # Store the current subsequence count as
                # max
                longest = counter
        return longest

d = Solution()
print(d.longest_subsequence([1, 9, 3, 10, 4, 20 , 2])) # 4
print(d.longest_subsequence([3, 9, 50, 2, 8, 4, 1])) # 4
print(d.longest_subsequence([1, 5, 29, 4, 3, 2, 1])) # 5 