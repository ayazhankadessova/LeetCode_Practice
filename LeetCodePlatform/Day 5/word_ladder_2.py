from collections import deque
class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        if endWord not in wordList:
            return []
        wordList.append(beginWord)
        wordList.append(endWord)
        distance = {}


        self.bfs(endWord, distance, wordList)

        results = []
        self.dfs(beginWord, endWord, distance, wordList, [beginWord], results)

        return results

    def bfs(self, start, distance, w):
        distance[start] = 0
        queue = deque([start])
        while queue:
            word = queue.popleft()
            for next_word in self.get_next_words(word, w):
                if next_word not in distance:
                    distance[next_word] = distance[word] + 1
                    queue.append(next_word)

    def get_next_words(self, word, w):
        words = []
        for i in range(len(word)):
            for letter in string.ascii_lowercase: # letters from a-z to make new words, changing one letter
                next_word = word[:i] + letter + word[i + 1:]
                if next_word != word and next_word in w:
                    words.append(next_word)
        return words
    
    # end if cur = lastWord
    def dfs(self, curt, target, distance, w, path, results):
        if curt == target:
            results.append(list(path))
            return

        for word in self.get_next_words(curt, w):
            if distance[word] != distance[curt] - 1:
                continue
            path.append(word)
            self.dfs(word, target, distance, w, path, results)
            path.pop()

        # final = []
        
        # to be able to remove from the start or end
        # lists in list
        # queue = deque([[beginWord]])
        # visited = set()
        # wordSet = set(wordList)
        
        # while queue:
            # curLayerWords = set()
            # for _ in range(len(queue)):
                # current_list = queue.popleft() # remove from the beginning
                # lastWord = current_list[-1]
                
                # last layer of words
                # if lastWord == endWord:
                    # final.append(current_list)
                    
                # next layer of words
                # for i in range(len(beginWord)):
                    # for letter in string.ascii_lowercase: # letters from a-z to make new words, changing one letter
                        # nextWord = lastWord[:i] + letter + lastWord[i+1:]
                        # if nextWord in wordSet and nextWord not in visited:
                            # queue.append(current_list + [nextWord])
                            # curLayerWords.add(nextWord)
                # visited.update(curLayerWords)
        # return final
                            
                            
                
                
                
    # A - z = 5* 26 < 1000 iterations. Change every letter.
    # Queues are different from arrays and lists in that queues are not random access—the data stored in a queue has a particular order. So if you want to add an item to a queue, it will be added to the end. This is called first-in, first-out, or a FIFO queue for short.
    # Dequeues - But what if we want to add and remove a number of items from either end of our queue? This is where the deque function comes in. By using deque, we can create a double-ended queue where we can add and remove elements from the start or end of the queue. Deques are last-in, first-out, or LIFO for short.