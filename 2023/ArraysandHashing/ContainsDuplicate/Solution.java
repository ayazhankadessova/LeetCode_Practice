class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Demonstrating Set using HashSet
        // Declaring object of type String
        Set<Integer> hash_Set = new HashSet<Integer>();

        for (int num : nums) {
            if (hash_Set.contains(num)) {
                return true;
            }
            hash_Set.add(num);
        }

        return false;
    }
}