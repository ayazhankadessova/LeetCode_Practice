class Solution:
    def reverseWords(self, s: str) -> str:
        list_words = s.split()
        list_words = [word[::-1] for word in list_words]
        
        return " ".join(word for word in list_words)