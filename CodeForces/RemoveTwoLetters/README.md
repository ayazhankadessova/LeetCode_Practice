https://codeforces.com/problemset/problem/1800/D

Dmitry has a string 𝑠𝑠, consisting of lowercase Latin letters.

Dmitry decided to remove two consecutive characters from the string 𝑠𝑠, and you are wondering how many different strings can be obtained after such an operation.

For example, Dmitry has a string "aaabcc". You can get the following different strings: "abcc" (by deleting the first two or second and third characters), "aacc" (by deleting the third and fourth characters), "aaac" (by deleting the fourth and the fifth character), and "aaab" (by deleting the last two).

Input:
The first line of input data contains a single integer 𝑡𝑡 (1 ≤ 𝑡 ≤ 10⁴) — number of test cases.

The descriptions of the test cases follow.

The first line of the description of each test case contains an integer 𝑛𝑛 (3 ≤ 𝑛 ≤ 2⋅10⁵).

The second line of the description of each test case contains a string 𝑠𝑠 of length 𝑛𝑛 consisting of lowercase Latin letters.

It is guaranteed that the sum of 𝑛𝑛 for all test cases does not exceed 2⋅10⁵.

Output:
For each test case, print one integer — the number of distinct strings that can be obtained by removing two consecutive letters.

- Input
  7
  6
  aaabcc
  10
  aaaaaaaaaa
  6
  abcdef
  7
  abacaba
  6
  cccfff
  4
  abba
  5
  ababa

- Output

4
1
5
3
3
3
1
