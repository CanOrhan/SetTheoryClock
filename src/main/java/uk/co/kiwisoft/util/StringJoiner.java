package uk.co.kiwisoft.util;

/**
 * Takes an array of Strings and produces a sentence with a space character in between each element.
 *
 * Example
 * Input: {"This", "is", "my", "input"}
 * Output: "This is my input"
 */
public class StringJoiner {
    public String join(String[] input) {
        String output = "";

        if(input != null) {
            for(String string : input) {
                output += string + " ";
            }
        }

        return output.trim();
    }
}
