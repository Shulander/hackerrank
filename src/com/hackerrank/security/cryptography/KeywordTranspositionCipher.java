package com.hackerrank.security.cryptography;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/keyword-transposition-cipher/submissions/code/21915200
 * https://www.hackerrank.com/challenges/keyword-transposition-cipher
 * <pre>
 * Sample Input
 * 2
 * SPORT
 * LDXTW KXDTL NBSFX BFOII LNBHG ODDWN BWK
 * SECRET
 * JHQSU XFXBQ
 * 
 * Sample Output
 * ILOVE SOLVI NGPRO GRAMM INGCH ALLEN GES
 * CRYPT OLOGY
 * </pre>
 * @author Shulander
 */
public class KeywordTranspositionCipher {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int nTests = in.nextInt();
        while (nTests-- > 0) {

            String keyword = in.next();
            in.nextLine();
            String ciphertext = in.nextLine();

            CipherImpl cipher = new CipherImpl(keyword);
            cipher.generateAlphabet();
            System.out.println(cipher.translate(ciphertext));
        }
    }

    private static class CipherImpl {

        private final String keyword;

        Map<Character, Character> cipherDictionary;
        Map<Character, Character> decipherDictionary;

        private CipherImpl(String keyword) {
            this.keyword = keyword;

            cipherDictionary = new HashMap<>();
            decipherDictionary = new HashMap<>();
        }

        private void generateAlphabet() {
            String uniqueKeyword = cleanUpKeyword();

            // generate the columns indexed by the keyword
            StringBuilder[] columnsKeys = new StringBuilder[uniqueKeyword.length()];
            for (int i = 0; i < columnsKeys.length; i++) {
                columnsKeys[i] = new StringBuilder();
                columnsKeys[i].append(uniqueKeyword.charAt(i));
            }

            // add all remaining characters to the columns
            int column = 0;
            for (char a = 'A'; a <= 'Z'; a++) {
                if (uniqueKeyword.indexOf(a) == -1) {
                    columnsKeys[column].append(a);
                    column = (column + 1) % uniqueKeyword.length();
                }
            }

            // sort the array by the oder of its first charactere
            Arrays.sort(columnsKeys, (StringBuilder o1, StringBuilder o2) -> o1.charAt(0) - o2.charAt(0));

            // generate the translate dictionary
            char alphabet = 'A';
            for (StringBuilder columnsKey : columnsKeys) {
                for (char c : columnsKey.toString().toCharArray()) {
                    cipherDictionary.put(alphabet, c);
                    decipherDictionary.put(c, alphabet);
                    alphabet++;
                }
            }
            cipherDictionary.put(' ', ' ');
            decipherDictionary.put(' ', ' ');

        }

        public String translate(String ciphertext) {
            return ciphertext.chars().mapToObj(cipherLetter -> decipherDictionary.get((char) cipherLetter))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        }
        
        public String cipher(String ciphertext) {
            return ciphertext.chars().mapToObj(cipherLetter -> cipherDictionary.get((char) cipherLetter))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
            
        }

        private String cleanUpKeyword() {
            String upperCaseKeyword = keyword.toUpperCase();

            StringBuilder sbUniqueKey = new StringBuilder();
            for (char c : upperCaseKeyword.toCharArray()) {
                if (sbUniqueKey.indexOf(c + "") == -1) {
                    sbUniqueKey.append(c);
                }
            }

            return sbUniqueKey.toString();
        }
    }
}
