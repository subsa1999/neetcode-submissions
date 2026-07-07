class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, Integer> hashToIndx = new HashMap<>();
        List<List<String>> list = new ArrayList<>();

        for (String s : strs) {
            Anagram a = new Anagram(s);
            int hash = a.hashCode();

            if (!hashToIndx.containsKey(hash)) {
                list.add(new ArrayList<>());
                hashToIndx.put(hash, list.size() - 1);
            }
            list.get(hashToIndx.get(hash)).add(a.val);
        }

        return list;
    }
}

class Anagram {
    String val;
    int[] charCount;

    public Anagram(String val) {
        this.val = val;
        charCount = new int[26];
        for (char c : val.toCharArray()) {
            charCount[c - 'a']++;
        }
    }

    public int hashCode() {
        return Arrays.hashCode(charCount);
    }
}
