package model;

import java.util.HashMap;
import java.util.Objects;

/*
 * Dictionary Model
 * contains a HashMap of String keys and String values
 *
 * void addWord(String word, String definition)
 * for adding words and definitions
 *
 * String getDefinitionByWord(String word)
 * returns a word's definition from the HashMap or a default message if not found
 */

public class Dictionary {
    private final HashMap<String, String> dictionary = new HashMap<>();

    public void addWord(String word, String definition) {
        dictionary.put(word, definition);
    }

    public String getDefinitionByWord(String word) {
        if (Objects.equals(word, "")) {
            return "Empty Query. Please type something!";
        } else {
            return dictionary.getOrDefault(word.toLowerCase(), "This word isn't in the dictionary.");
        }
    }
}
