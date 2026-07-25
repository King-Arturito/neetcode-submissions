class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, String> map = new HashMap<>();
        Map<String, List<String>> result = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String newStr = new String(arr);
            map.put(str, newStr);
            result.putIfAbsent(newStr, new ArrayList<>());
        }

        for (String str : strs) {
            result.get(map.get(str)).add(str);
        }

        return new ArrayList<>(result.values());
    }
}
