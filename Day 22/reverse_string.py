class Solution:
    def reverse_string(self, string: str) -> str:
        string_list = list(string)
        left = 0
        right = len(string_list) - 1
        while left < right :
            string_list[left], string_list[right] = string_list[right], string_list[left]
            left, right = left + 1, right - 1
        print("".join(string_list))

def main():
    p = Solution()
    p.reverse_string('hello')
  
  
if __name__ == '__main__':
    main()