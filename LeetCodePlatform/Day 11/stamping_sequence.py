class Solution:
    def movesToStamp(self, stamp: str, target: str) -> List[int]:
        
        # Go through the entire string 
        # If we couldnt find stamp that works, 
        # return empty array
            
            
        target_length, stamp_length = len(target), len(stamp)
        output = []
        
        # do while loop, but limit to max number of moves
        move, maxmoves = 0, 10* target_length
        # to know if we didnt find any moves suitable:
        premove = 0
        
        def check(subsequence, stamp):
            works = True
            for i in range(stamp_length):
                if subsequence[i] == stamp[i]:
                    works = True
                elif subsequence[i] == "?":
                    continue
                else:
                    return False
            return works
                    
                
        while move<maxmoves:
            premove = move
            for i in range(target_length-stamp_length+1):
                # check if stamp == subsequence
                # if ==, replace target with ?
                if check(target[i:i+stamp_length], stamp):
                    move +=1
                    output.append(i)
                    target = target[:i]+"?"*stamp_length+target[i+stamp_length:]
                    if target == "?"* target_length:
                        return reversed(output)
                    
            # if after checking every char, premove is still move, means no answer
            if premove == move:
                return []