// https://leetcode.com/problems/valid-anagram/

class Solution {
    public boolean isAnagram(String inputString, String inputString2) {

        if (inputString.length() != inputString2.length()) {
            return false;
        }
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> charCountMap2 = new HashMap<Character, Integer>();

        // Converting given string to char array

        char[] strArray = inputString.toCharArray();
        char[] strArray2 = inputString2.toCharArray();

        // checking each char of strArray
        for (int i = 0; i < strArray.length; i++) {
            if (charCountMap.containsKey(strArray[i])) {

                // If char is present in charCountMap,
                // incrementing it's count by 1
                charCountMap.put(strArray[i], charCountMap.get(strArray[i]) + 1);
            } else {

                // If char is not present in charCountMap,
                // putting this char to charCountMap with 1 as it's value
                charCountMap.put(strArray[i], 1);
            }

            if (charCountMap2.containsKey(strArray2[i])) {

                // If char is present in charCountMap,
                // incrementing it's count by 1
                charCountMap2.put(strArray2[i], charCountMap2.get(strArray2[i]) + 1);
            } else {

                // If char is not present in charCountMap,
                // putting this char to charCountMap with 1 as it's value
                charCountMap2.put(strArray2[i], 1);
            }

        }

        for (Map.Entry entry : charCountMap.entrySet()) {
            // Integer value1 = entry.getValue();
            // // Integer value2 = charCountMap2.get(entry.getKey());
            // System.out.println(entry.getKey() + " " + entry.getValue());

            // System.out.println(charCountMap2.get(entry.getKey()));

            if (entry.getValue() != charCountMap2.get(entry.getKey())) {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
                System.out.println(charCountMap2.get(entry.getKey()));

                return false;
            }
        }

        return true;
    }
}
