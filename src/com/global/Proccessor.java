package com.global;

import java.util.*;

/**
 * @author Roshni Das
 * @created 05/11/2022
 * @project AnagramSolver
 */
public class Proccessor {

    public int getID(String s) {
        int[] counter = new int[26];
        for (char ch : s.toCharArray()) {
            counter[ch - 'a']++;
        }

        return Arrays.hashCode(counter);    //use the counter array's hash code as this anagram's ID
    }

    public List<List<String>> findAllAnagrams(List<String> listOfWords) {
        Map<Integer, List<String>> anagramMap = new HashMap<>();

        for (String word : listOfWords) {
            int id = getID(word);   //unique for each anagram
            List<String> group = anagramMap.computeIfAbsent(id, k -> new ArrayList<>());

            group.add(word);
        }
        return new ArrayList<>(anagramMap.values());
    }
}
