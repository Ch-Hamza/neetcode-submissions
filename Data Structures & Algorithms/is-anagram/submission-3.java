class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> occ1 = getOccurences(s);
        Map<Character, Integer> occ2 = getOccurences(t);
        // System.out.println(occ1.size());
        // System.out.println(occ2.size());

        // or just compare length before
        return compareOccurences(occ1, occ2) && compareOccurences(occ2, occ1);
    }

    private Map<Character, Integer> getOccurences(String s) {
        Map<Character, Integer> occ = new HashMap<Character, Integer>();
        for (Character c : s.toCharArray()) {
            if (occ.containsKey(c)) {
                occ.computeIfPresent(c, (k, v) -> v + 1);
            } else {
                occ.put(c, 1);
            }
        }
        return occ;
    }

    private boolean compareOccurences(Map<Character, Integer> occ1, Map<Character, Integer> occ2) {
        for (Map.Entry<Character, Integer> entry : occ1.entrySet()) {
            if (!occ2.containsKey(entry.getKey()) || !Objects.equals(entry.getValue(), occ2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
}