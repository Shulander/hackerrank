package amazon;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Shulander
 */
public class Problem1 {

    public static void main(String[] args) {
        System.out.println(minimumRemovals("ABC", "ABC"));
        System.out.println(minimumRemovals("AAAABCCDE", "AABCDEE"));
        System.out.println(minimumRemovals("ABBBCADA", "AAABCAAD"));
        
        System.out.println("---------------------");
        System.out.println(minimumRemovals2("ABC", "ABC"));
        System.out.println(minimumRemovals2("AAAABCCDE", "AABCDEE"));
        System.out.println(minimumRemovals2("ABBBCADA", "AAABCAAD"));
    }
    
    

    public static int minimumRemovals2(String s1, String s2) {
        // this solution uses Maps to count re
        // one map fo
        
        Map<Integer, Integer> charMapString1 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            Integer c = Character.getNumericValue(s1.charAt(i));
            if(charMapString1.containsKey(c)) {
                charMapString1.put(c, charMapString1.get(c)+1);
            } else {
                charMapString1.put(c, 1);
            }
        }
        
        Map<Integer, Integer> charMapString2 = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            Integer c = Character.getNumericValue(s2.charAt(i));
            if(charMapString2.containsKey(c)) {
                charMapString2.put(c, charMapString2.get(c)+1);
            } else {
                charMapString2.put(c, 1);
            }
        }
        
        int returnValue = 0;
        for (Map.Entry<Integer, Integer> entrySet : charMapString1.entrySet()) {
            if(charMapString2.containsKey(entrySet.getKey())) {
                int a = entrySet.getValue();
                int b = charMapString2.get(entrySet.getKey());
                if(a>b){
                    returnValue += (a-b);
                } else {
                    returnValue += (b-a);
                }
                charMapString2.remove(entrySet.getKey());
            } else {
                return -1;
            }
        }
        
        if(!charMapString2.isEmpty()) {
            return -1;
        }
        
        return returnValue;
    }
  
    public static int minimumRemovals(String s1, String s2) {

        // check data
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("the string parameter must be a valid string");
        }

        int i = 0;
        int j = 0;
        int returnValue = 0;
        while (i < s1.length() && j < s2.length()) {
            
            // increments both indexes while both characteres are the same
            while(i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            }
            
            if(i < s1.length() && s1.charAt(i) == s1.charAt(i-1)) {
                // case the character in the second string changes 
                // we must count the characteres in to remove in the first string
                while(i < s1.length() && s1.charAt(i) == s1.charAt(i-1)) {
                    i++;
                    returnValue++;
                }
            } else if( j < s2.length() && s2.charAt(j) == s2.charAt(j-1)) {
                // case the character in the first string changes 
                // we must count the characteres to remove in the second string
                while( j < s2.length() && s2.charAt(j) == s2.charAt(j-1)) {
                    j++;
                    returnValue++;
                }
            }
            
            // check ending condition
            // this condition means that the new last character in each string are diferent 
            if(i < s1.length() && j < s2.length()) {
                if(s1.charAt(i) != s2.charAt(j)) {
                    return -1;
                }
            } else if(i < s1.length()) {
                if(s1.charAt(i) != s2.charAt(j-1)) {
                    return -1;
                }
            } else if(j < s2.length()) {
                if(s1.charAt(i-1) != s2.charAt(j)) {
                    return -1;
                }
            }
        }
        
        // return the final characters count
        return returnValue;

    }
    
    public static int minimumRemovals3(String s1, String s2) {

        // check data
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("the string parameter must be a valid string");
        }

        int i = 0;
        int j = 0;
        int returnValue = 0;
        while (i < s1.length() && j < s2.length()) {
            while(i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            }
            if(i < s1.length() && s1.charAt(i) == s1.charAt(i-1)) {
                while(i < s1.length() && s1.charAt(i) == s1.charAt(i-1)) {
                    i++;
                    returnValue++;
                }
            } else if( j < s2.length() && s2.charAt(j) == s2.charAt(j-1)) {
                while( j < s2.length() && s2.charAt(j) == s2.charAt(j-1)) {
                    j++;
                    returnValue++;
                }
            }
            
            // check ending condition
            // this condition means that the new last character in each string are diferent 
            if(i < s1.length() && j < s2.length()) {
                if(s1.charAt(i) != s2.charAt(j)) {
                    return -1;
                }
            } else if(i < s1.length()) {
                if(s1.charAt(i) != s2.charAt(j-1)) {
                    return -1;
                }
            } else if(j < s2.length()) {
                if(s1.charAt(i-1) != s2.charAt(j)) {
                    return -1;
                }
            }
        }
        
        return returnValue;

    }
}
