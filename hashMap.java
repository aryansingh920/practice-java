
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


public class hashMap {
    public static int firstUniqueCharIndex(String s) {
        HashMap<Character, LinkedList<Integer>> charIndexMap = new HashMap<>();
        int firstIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (charIndexMap.containsKey(currentChar)) {
                LinkedList<Integer> currList = charIndexMap.get(currentChar);
                currList.add(i);
            } else {
                LinkedList<Integer> newList = new LinkedList<>(List.of(i));
                charIndexMap.put(currentChar, newList);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (charIndexMap.get(currentChar).size() == 1) {
                firstIndex = charIndexMap.get(currentChar).get(0);
                return firstIndex;
            }
        }
        return firstIndex;
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i : nums) {
            if (hashSet.contains(i)) {
                return true;
            }
            hashSet.add(i);
        }

        return false;
    }

    public static void main(String[] args) {
        // int Output = firstUniqueCharIndex("leeldezd");
        // System.out.println(Output);

        System.out.println(containsDuplicate(new int[] { 4, 2, 3, 1, 4 }));
    }
}
