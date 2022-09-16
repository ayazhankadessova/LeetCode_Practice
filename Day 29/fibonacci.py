
# creating an array in the function to find the nth number in fibonacci series. [0, 1, 1, ...]

def fibonacci(n):
   if n <= 0:
     return "Incorrect Output"
   data = [1, 1]
   if n > 2:
    for i in range(2, n):
        data.append(data[i-1] + data[i-2])
    return data[n-1]
 
# Driver Program
 
print(fibonacci(10))
 
# This Code is contributed by Prasun Parate (prasun_parate)
