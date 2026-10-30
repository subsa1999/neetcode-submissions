class Solution {
    private String key(String s) {
        char[] crr = s.toCharArray();
        Arrays.sort(crr);
        return new String(crr); 
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            map.computeIfAbsent(key(str), _key -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
