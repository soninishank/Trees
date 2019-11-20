import java.util.*;

public class Test1 {

    String findSubString(String str) {
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
        }
        int flag = set.size();
        int diff = Integer.MAX_VALUE;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            hashMap.put(aChar, i);
            if (hashMap.size() == flag) {
                Collection<Integer> values = hashMap.values();
                int maxValueInMap = (Collections.max(values));
                int minValueInMap = Collections.min(hashMap.values());
                int temp = maxValueInMap - minValueInMap + 1;
                if (temp < diff) {
                    diff = temp;
                    startIndex = minValueInMap;
                    endIndex = maxValueInMap;
                }
            }
        }

        String strs = str.substring(startIndex, endIndex + 1);

        System.out.println(strs);
        return "";

    }


    public static void main(String[] args) {
        String str = "aaabbbbccccccdddd";
        String subString = new Test1().findSubString(str);


    }
}
