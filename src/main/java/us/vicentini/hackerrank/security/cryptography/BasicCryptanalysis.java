package us.vicentini.hackerrank.security.cryptography;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Shulander
 */
public class BasicCryptanalysis {

    public static void main(String[] args) {

        try {
            DictionaryAnalysis analysis = new DictionaryAnalysis();

            InputStream dictionaryFile = BasicCryptanalysis.class.getResourceAsStream("dictionary.lst");
            InputStream inputFile = BasicCryptanalysis.class.getResourceAsStream("BasicCryptanalysisInput.txt");

            analysis.loadDictionaryFile(dictionaryFile);

            Scanner in = new Scanner(inputFile);
//            Scanner in = new Scanner(System.in);
            String strInput = in.nextLine();

            analysis.processInputText(strInput);

            analysis.process();

            String str = analysis.translate(strInput);
            System.out.println(str);
        } catch (IOException ex) {
            System.out.println("error loading file: " + ex.getMessage());
        }
    }

    private static class DictionaryAnalysis {

        Map<Integer, List<String>> sizeDictionaryMap;
        List<String> dictionaryList;

        Map<Integer, List<String>> wordMap;
        List<String> wordList;

        Map<Character, Character> dictionaryMap;

        public DictionaryAnalysis() {
            sizeDictionaryMap = new HashMap<>();
            dictionaryList = new LinkedList<>();

            wordMap = new TreeMap<>();
            wordList = new LinkedList<>();

            dictionaryMap = new HashMap<>();
        }

        public void loadDictionaryFile(InputStream pathFile) throws IOException {
            Scanner sc = new Scanner(pathFile);
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                dictionaryList.add(str.toLowerCase());
                if (!sizeDictionaryMap.containsKey(str.length())) {
                    sizeDictionaryMap.put(str.length(), new LinkedList<>());
                }
                sizeDictionaryMap.get(str.length()).add(str);
            }
            sc.close();
        }

        public void processInputText(String strInput) {
            Scanner sc = new Scanner(strInput);
            while (sc.hasNext()) {
                String str = sc.next();
                wordList.add(str.toLowerCase());
                if (!wordMap.containsKey(str.length())) {
                    wordMap.put(str.length(), new LinkedList<>());
                }
                wordMap.get(str.length()).add(str);
            }
            sc.close();
        }

        public void process() {
            List<String> remainingWords = new LinkedList<>();
            for (String word : wordList) {
                if (!buildDictionaryKnownWords(word)) {
                    remainingWords.add(word);
                }
            }

            boolean hasChanged;
            do {
                hasChanged = false;
                List<String> finalWords = new LinkedList<>();
                for (String word : remainingWords) {
                    if (!buildDictionaryProbableWords(word)) {
                        finalWords.add(word);
                    } else {
                        hasChanged = true;
                    }
                }
                remainingWords = finalWords;
            } while (hasChanged && !remainingWords.isEmpty());
        }

        private boolean buildDictionaryKnownWords(String word) {
            List<String> possiblewords = sizeDictionaryMap.get(word.length());
            if (possiblewords == null) {
                return false;
            }
            if (possiblewords.size() == 1) {
                addMap(word, possiblewords.get(0));
            } else {
                String[] doubleCharList = filterWordsWithDoubleChar(word, possiblewords);
                String found = checkProbableTranslation(word, 0, doubleCharList);
                if (found != null) {
                    addMap(word, found);
                    return true;
                }
            }
            return false;
        }

        private boolean buildDictionaryProbableWords(String word) {
            List<String> possiblewords = sizeDictionaryMap.get(word.length());
            if (possiblewords == null && possiblewords.size() == 1) {
                return false;
            }

            String found = checkProbableTranslation(word, 2, possiblewords.toArray(new String[0]));
            if (found != null) {
                addMap(word, found);
                return true;
            }
            return false;

        }

        private void addMap(String fromWord, String toWord) {
            char[] from = fromWord.toCharArray();
            char[] to = toWord.toCharArray();
            for (int i = 0; i < to.length; i++) {
                Character old = dictionaryMap.put(from[i], to[i]);
                old = dictionaryMap.put(Character.toUpperCase(from[i]), Character.toUpperCase(to[i]));
//                if (old != null) {
//                    if (old != to[i]) {
//                        System.out.println("error, redefined character '" + from[i] + "': from '" + old + "' to '" + to[i] + "'");
//                    } else {
//                        System.out.println("confirmed translation: for '" + from[i] + "' to '" + to[i] + "'");
//                    }
//                } else {
//                    System.out.println("new translation for '" + from[i] + "' to '" + to[i] + "'");
//                }
            }
        }

        private int[] hasDoubleChar(String word, int startPosition) {
            char[] chars = word.toCharArray();
            for (int i = startPosition; i < chars.length; i++) {
                char aChar = chars[i];
                if (word.indexOf(aChar, i + 1) != -1) {
                    return new int[]{i, word.indexOf(aChar, i + 1)};
                }
            }
            return new int[]{-1, -1};
        }

        private int calculatePossibleIndex(String fromWord, String toWord) {
            char[] from = fromWord.toCharArray();
            char[] to = toWord.toCharArray();

            int returnValue = 1;
            for (int i = 0; i < from.length; i++) {
                char c = from[i];
                if (this.dictionaryMap.containsKey(c)) {
                    if (dictionaryMap.get(c) == to[i]) {
                        returnValue += 1;
                    } else {
                        return -100;
                    }
                }
            }
            return returnValue;
        }

        private String[] filterWordsWithDoubleChar(String word, List<String> possiblewords) {
            List<String> returnValue = new LinkedList<>();

            int[] doublePosition = hasDoubleChar(word, 0);
            if (doublePosition[0] != -1) {
                String[] words = new String[possiblewords.size()];
                words = possiblewords.toArray(words);

                while (doublePosition[0] != -1) {
                    for (String possibleword : words) {
                        int[] foundDouble = hasDoubleChar(possibleword, doublePosition[0]);

                        if (Arrays.equals(foundDouble, doublePosition)) {
                            returnValue.add(possibleword);
                        }
                    }

                    doublePosition = hasDoubleChar(word, 1 + doublePosition[0]);

                    words = new String[returnValue.size()];
                    words = returnValue.toArray(words);
                    returnValue.clear();
                }
                return words;
            }

            return new String[0];
        }

        private String checkProbableTranslation(String word, int minimunIdx, String... doubleCharList) {

            String found = null;
            int foundIdx = 0;
            for (String possibleword : doubleCharList) {
                int newIdx = calculatePossibleIndex(word, possibleword);
                if (newIdx == foundIdx) {
//                    System.out.println("found same idx...");
                    found = null;
                } else if (newIdx > foundIdx && newIdx >= minimunIdx) {
                    found = possibleword;
                    foundIdx = newIdx;
                }
            }
            return found;
        }

        private String translate(String word) {
            StringBuilder sb = new StringBuilder();

            char[] chars = word.toCharArray();
            for (char c : chars) {
                if (this.dictionaryMap.containsKey(c)) {
                    sb.append(dictionaryMap.get(c));
                } else {
                    sb.append(c);
                }
            }

            return sb.toString();
        }
    }
}
