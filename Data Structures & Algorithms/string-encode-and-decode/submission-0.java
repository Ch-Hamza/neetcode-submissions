class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        }

        String sizes = strs.stream()
            .map(str -> str.toCharArray().length + ",")
            .collect(Collectors.joining());
        String words = strs.stream()
            .collect(Collectors.joining());
        System.out.println(sizes);
        System.out.println(words);
        return sizes + "#" + words;
    }

    public List<String> decode(String str) {
        if (str.length() == 0) {
            return List.of();
        }
        System.out.println(str);


        String[] split = str.split("#");
        String[] sizes = split[0].split(",");
        String words = split.length > 1 ? split[1] : "";
        for (String x : sizes) {
            System.out.println(x);
        }
        System.out.println(words);

        List<String> res = new ArrayList();
        int start = 0;
        for(int i = 0; i < sizes.length; i++) {
            System.out.println("start : " + start);
            int size = Integer.valueOf(sizes[i]);
            System.out.println("size : " + size);
            String word = words.substring(start, start + size);
            System.out.println("word : " + word);
            start += size;
            res.add(word);
        }

        return res;
    }
}
