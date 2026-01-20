
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


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

    public static int[] findKLargest(int[] nums, int k) {
        PriorityQueue<Integer> heapPriorityQueue = new PriorityQueue<>();

        for (int i : nums) {
            heapPriorityQueue.add(i);
            if (heapPriorityQueue.size() > k) {
                heapPriorityQueue.poll();
            }
        }
        int[] result = new int[k];
        int index = 0;

        while (!heapPriorityQueue.isEmpty()) {
            result[index++] = heapPriorityQueue.poll();
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println("firstUniqueCharIndex : " + firstUniqueCharIndex("leeldezd"));
        System.out.println("containsDuplicate : " + containsDuplicate(new int[] { 4, 2, 3, 1, 4 }));
        System.out.println("findKLargest : " + Arrays.toString(findKLargest(new int[] { 7, 10, 4, 3, 16, 20, 15 }, 3)));

    }
}
