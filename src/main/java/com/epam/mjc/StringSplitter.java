package com.epam.mjc;

import java.util.*;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> result = new ArrayList<>();
        StringBuilder delims = new StringBuilder();
        for (String delim : delimiters) {
            delims.append(delim);
        }
        StringTokenizer split = new StringTokenizer(source, delims.toString());
        while(split.hasMoreTokens()){
            result.add(split.nextToken());
        }
        return result;
    }
}
