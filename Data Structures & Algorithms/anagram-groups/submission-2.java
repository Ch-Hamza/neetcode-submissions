class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> occurences = new HashMap();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < strs.length; i++) {
            int[] occ = new int[26];
            char[] chars = strs[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                int index = alphabet.indexOf(chars[j]);
                occ[index] = occ[index] + 1;
            }

            // System.out.println("---------");
            // for(int x = 0; x < occ.length; x++) {
            //     System.out.print(occ[x]);
            // }
            // System.out.println("---------");

            String key = getWordFromArray(occ);
            // System.out.println("key : " + key);
            if (occurences.containsKey(key)) {
                List<String> updatedList = Stream.concat(occurences.get(key).stream(), List.of(strs[i]).stream())
                    .collect(Collectors.toList());
                occurences.put(key, updatedList);
            } else {
                occurences.put(key, List.of(strs[i]));
            }
        }

        List<List<String>> res = occurences.values().stream().collect(Collectors.toList());
        // for(List<String> l : res) {
            // for (String s : l) {
            //     System.out.print(s + ", ");
            // }
            // System.out.println("");
        // }
        return res;
    }

    private String getWordFromArray(int[] occ) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i < 26; i++) {
            for(int j=0; j < occ[i]; j++) {
                sb.append((char) ('a' + i));
            }
        }

        return sb.toString();
    }

}
