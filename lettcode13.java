import java.util.HashMap;
import java.util.Map;

class lettcode13 {
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            result = result + map.get(ch);

            if (i != 0) {
                char prevCh = s.charAt(i - 1);
                if ((prevCh == 'I' && ch == 'V') || (prevCh == 'I' && ch == 'X')) {
                    result = result - (2);
                } else if ((prevCh == 'X' && ch == 'L') || (prevCh == 'X' && ch == 'C')) {
                    result = result - 20;
                } else if ((prevCh == 'C' && ch == 'D') || (prevCh == 'C' && ch == 'M')) {
                    result = result - 200;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int result = romanToInt("MCMXCIV");
        System.out.println("Result : " + result);
    }
}
