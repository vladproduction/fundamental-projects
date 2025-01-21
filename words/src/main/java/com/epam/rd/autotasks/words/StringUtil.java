package com.epam.rd.autotasks.words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class StringUtil {

    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        int countWords = 0;

        if (words == null || words.length == 0 || sample == null) {
            return 0;
        }

        String sampleTrimmed = sample.trim();

        for (String word : words) {
            if (word.trim().equalsIgnoreCase(sampleTrimmed)) {
                countWords++;
            }
        }

        return countWords;
    }

    public static String[] splitWords(String text) {

        if (text == null || text.trim().isEmpty()) {
            return null;
        }

        String regex = "[,.;: ?!]+";

        String[] wordsResult = text.trim().split(regex);

        List<String> validWords = new ArrayList<>();

        for (String word : wordsResult) {
            String strippedWord = word.strip();
            if (!strippedWord.isEmpty()) {
                validWords.add(strippedWord);
            }
        }

        if (validWords.isEmpty()) {
            return null;
        }

        return validWords.toArray(new String[0]);
    }

    public static String convertPath(String path, boolean toWin) {

        if (path == null || path.isEmpty()) {
            return null;
        }

        if (isInvalidPath(path)) {
            return null;
        }

        boolean isUnix = isUnixPath(path);
        boolean isWindows = isWindowsPath(path);

        if ((toWin && isWindows) || (!toWin && isUnix)) {
            return path;
        }

        return toWin ? convertToWindowsPath(path) : convertToUnixPath(path);
    }

    private static boolean isUnixPath(String path) {
        return path.startsWith("/") || path.startsWith("~");
    }

    private static boolean isWindowsPath(String path) {
        return path.matches("^[a-zA-Z]:.*") || path.startsWith("\\");
    }

    private static boolean isInvalidPath(String path) {

        int tildeCount = 0;
        int driveCount = 0;
        boolean hasForwardSlash = false;
        boolean hasBackSlash = false;

        if (path.matches(".*\\\\{2,}.*") || path.matches(".*/{2,}.*")) {
            return true;
        }

        for (int i = 0; i < path.length(); i++) {

            char c = path.charAt(i);

            if (c == '~') {
                tildeCount++;
                if (i != 0) {
                    return true;
                }
            }
            if (c == 'C' && (i < path.length() - 1 && path.charAt(i + 1) == ':')) {
                driveCount++;
                if (i != 0) {
                    return true;
                }
            }

            if (i > 0 && ((c == '\\' && path.charAt(i - 1) == '/') || (c == '/' && path.charAt(i - 1) == '\\'))) {
                return true;
            }

            if (c == '/') {
                hasForwardSlash = true;
            } else if (c == '\\') {
                hasBackSlash = true;
            }
        }

        if (hasForwardSlash && hasBackSlash) {
            return true;
        }

        return tildeCount > 1 || driveCount > 1 || (path.contains("~") && path.contains("\\")) || (path.contains("C:") && path.startsWith("/"));
    }

    private static String convertToWindowsPath(String path) {

        String converted = path.replace('/', '\\');

        if (path.startsWith("~")) {
            converted = "C:\\User" + converted.substring(1);
        } else if (path.startsWith("/")) {
            converted = "C:\\" + converted.substring(1);
        }

        return converted;
    }

    private static String convertToUnixPath(String path) {

        String converted = path.replace('\\', '/');

        if (converted.startsWith("C:/User")) {
            converted = "~" + converted.substring(7);
        } else if (converted.startsWith("C:/")) {
            converted = "/" + converted.substring(3);
        }

        return converted;
    }

    public static String joinWords(String[] words) {

        if (words == null || words.length == 0) {
            return null;
        }

        StringJoiner joiner = new StringJoiner(", ", "[", "]");

        for (String word : words) {
            if (word != null && !word.strip().isEmpty()) {
                joiner.add(word);
            }
        }

        String result = joiner.toString();

        return result.equals("[]") ? null : result;
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS",};
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}