public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        String[] lowerSentence = new String[sentences.length];
        String[] lowerKey = new String[keywords.length];

        // Turns our sentence into lowercase, first iterates through words
        for (int i = 0; i < sentences.length; i++) {
            // Initialize lowercase array
            lowerSentence[i] = "";

            // For each word, turns all characters into lowercase
            for (int j = 0; j < sentences[i].length(); j++) {
                
                char letter = sentences[i].charAt(j);

                // If uppercase, converts to lowercase (otherwise stays same)
                if (letter >= 'A' && letter <= 'Z') {
                    letter = (char)(letter + 32);
                }
                // Adds the lowercase letter to the word in the new lowercase array
                lowerSentence[i] += letter;
                }
        }

        // Turns our keywords into lowercase, first iterates through words
        for (int i = 0; i < keywords.length; i++) {
            // Initialize lowercase array
            lowerKey[i] = "";

            // For each word, turns all characters into lowercase
            for (int j = 0; j < keywords[i].length(); j++) {
                
                char letter = keywords[i].charAt(j);

                // If uppercase, converts to lowercase (otherwise stays same)
                if (letter >= 'A' && letter <= 'Z') {
                    letter = (char)(letter + 32);
                }
                // Adds the lowercase letter to the word in the new lowercase array
                lowerKey[i] += letter;
                }
        }

        // For each sentence
        for (int i = 0; i < lowerSentence.length; i++) {
            String sentenceWord = lowerSentence[i];
            boolean sentenceHasKeyword = false;
    
            // For each keyword
            for (int j = 0; j < lowerKey.length && !sentenceHasKeyword; j++) {
                
                String keyword = lowerKey[j];
    
                // Try each starting index in this sentence
                for (int start = 0; start <= sentenceWord.length() - keyword.length(); start++) {
    
                    // First letter matches?
                    if (sentenceWord.charAt(start) == keyword.charAt(0)) {
    
                        boolean fullMatch = true;
    
                        // Check the rest of the letters
                        for (int k = 1; k < keyword.length(); k++) {
                            if (sentenceWord.charAt(start + k) != keyword.charAt(k)) {
                                fullMatch = false;
                                break;
                            }
                        }
    
                        if (fullMatch) {
                            sentenceHasKeyword = true;
                            break; // stop checking more start positions for this keyword
                        }
                    }
                }
            }
    
            if (sentenceHasKeyword) {
                // Print original sentence (with original capitalization)
                System.out.println(sentences[i]);
            }
        }
    


    }
}
