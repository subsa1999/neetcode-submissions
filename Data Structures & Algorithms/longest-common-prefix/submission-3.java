class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i = 0;

        
        for (; ; ++i) {
            if (strs[0].length() <= i) break;
            
            char c = strs[0].charAt(i);
            boolean _break = false;

            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].length() <= i) {
                    _break = true;
                    break;
                }

                if (strs[j].charAt(i) != c) {
                    _break = true;
                    break;
                }
            }

            if (_break) break;
        }

        return strs[0].substring(0, i);
    }
}