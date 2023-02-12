class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        
        if len(words) == 1:
            return 1
        elif len(words) == 0:
            return 0
        morse_keys = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        alphabet_values = list(string.ascii_lowercase)
        # using zip()
        # to make a alphabet letter -> morse key dictionary
        res = dict(zip(alphabet_values, morse_keys)) 
        
        word_morse = []
        for word in words:
            new_word = ''
            for letter in word:
                letter = letter.replace(letter.lower(), res[letter])
                new_word += letter
            
            word_morse.append(new_word)
        length = len(list(set(word_morse)))
        return length