package day04;

import java.util.Map;
import java.util.TreeMap;

public class VowelStatistics {

    public static void main(String[] args) {
        VowelStatistics vs = new VowelStatistics();
        System.out.println(vs.countVowelsIn(
                "Technology has advanced so far that cyborgs are commonplace. " +
                        "In addition, human brains can connect to the internet directly."
        ));
    }

    public Map<Character, Integer> countVowelsIn(String text) {
        Map<Character, Integer> result = new TreeMap<>();

        for (char c: text.toLowerCase().toCharArray()) {
            if (isVowel(c)) {
                refreshMap(result, c);
            }
        }
        return result;
    }

    private boolean isVowel(char c) {
        final String VOWELS = "aeiou";
        return VOWELS.indexOf(c) >= 0;
    }

    private void refreshMap(Map<Character, Integer> map, char vowel) {
        if (map.containsKey(vowel)) {
            map.put(vowel, map.get(vowel) + 1);
        } else {
            map.put(vowel, 1);
        }
    }
}
