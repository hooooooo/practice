class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.remove(ch);
            } else {
                map.put(ch, 0);
            }
        }
        return map.size() < 2;
    }
}
