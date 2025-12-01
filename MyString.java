public class MyString {
    public static void main(String[] args) {
        System.out.println("Testing lowercase:");
        System.out.println("UnHappy : " + lowerCase("UnHappy"));
        System.out.println("This costs 15 Sheksls : " + lowerCase("This costs 15 Sheksls"));
        System.out.println("TLV : " + lowerCase("TLV"));
        System.out.println("lowercase : " + lowerCase("lowercase"));

        System.out.println("Testing contains:");
        System.out.println(contains("unhappy", "happy")); // true
        System.out.println(contains("happy", "unhappy")); // false
        System.out.println(contains("historical", "story")); // false
        System.out.println(contains("psychology", "psycho")); // true
        System.out.println(contains("personality", "son")); // true
        System.out.println(contains("personality", "dad")); // false
        System.out.println(contains("resignation", "sign")); // true
    }

    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {

        String loweString = "";

        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (letter >= 'A' && letter <= 'Z') {
                letter = (char)(letter + 32);
                loweString += letter;
            } else {
                loweString += letter;
            }
        }

        return loweString;
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        
        // If str2 is larger than str1, automatically it can't be contained
        if (str2.length() > str1.length()) {
            return false;
        }

        // Accounts for all points in str1 that str2 can start from
        for (int startPoint = 0; startPoint <= str1.length() - str2.length(); startPoint++) {
            
            boolean isContained = true;

            // Checks if str2 is contained in str1 from a specific starting point
            for (int i = 0; i < str2.length(); i++) {
                if (str1.charAt(startPoint + i) != str2.charAt(i)) {
                    isContained = false;
                    break;
                }
            }

            // after going through all permutaions of str2 in str1, if str2 is contained in str1, return true
            if (isContained) {
                return true;
            }
        }

        return false;
    }
}
