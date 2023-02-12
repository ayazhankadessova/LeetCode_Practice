# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        values = []

        curr = head

        while curr:
            values.append(curr.val)
            curr = curr.next
        
        values.sort() # sort an array
        
        dummy = ListNode(0)
        cur = dummy
        
        for value in values:
            cur.next = ListNode(value)
            cur = cur.next 
            
        return dummy.next
            
        
        