import java.util.*;

public class MorseCodeConverter 
{


    private static final Map<Character, String> textToMorse = new HashMap<>();
    private static final Map<String, Character> morseToText = new HashMap<>();


    static 
    {
        // Letters
        textToMorse.put('A', ".-");
        textToMorse.put('B', "-...");
        textToMorse.put('C', "-.-.");
        textToMorse.put('D', "-..");
        textToMorse.put('E', ".");
        textToMorse.put('F', "..-.");
        textToMorse.put('G', "--.");
        textToMorse.put('H', "....");
        textToMorse.put('I', "..");
        textToMorse.put('J', ".---");
        textToMorse.put('K', "-.-");
        textToMorse.put('L', ".-..");
        textToMorse.put('M', "--");
        textToMorse.put('N', "-.");
        textToMorse.put('O', "---");
        textToMorse.put('P', ".--.");
        textToMorse.put('Q', "--.-");
        textToMorse.put('R', ".-.");
        textToMorse.put('S', "...");
        textToMorse.put('T', "-");
        textToMorse.put('U', "..-");
        textToMorse.put('V', "...-");
        textToMorse.put('W', ".--");
        textToMorse.put('X', "-..-");
        textToMorse.put('Y', "-.--");
        textToMorse.put('Z', "--..");


        // Numbers
        textToMorse.put('0', "-----");
        textToMorse.put('1', ".----");
        textToMorse.put('2', "..---");
        textToMorse.put('3', "...--");
        textToMorse.put('4', "....-");
        textToMorse.put('5', ".....");
        textToMorse.put('6', "-....");
        textToMorse.put('7', "--...");
        textToMorse.put('8', "---..");
        textToMorse.put('9', "----.");


        // Special characters and punctuation
        textToMorse.put('.', ".-.-.-");
        textToMorse.put(',', "--..--");
        textToMorse.put('?', "..--..");
        textToMorse.put('\'', ".----.");
        textToMorse.put('!', "-.-.--");
        textToMorse.put('/', "-..-.");
        textToMorse.put('(', "-.--.");
        textToMorse.put(')', "-.--.-");
        textToMorse.put('&', ".-...");
        textToMorse.put(':', "---...");
        textToMorse.put(';', "-.-.-.");
        textToMorse.put('=', "-...-");
        textToMorse.put('+', ".-.-.");
        textToMorse.put('-', "-....-");
        textToMorse.put('_', "..--.-");
        textToMorse.put('"', ".-..-.");
        textToMorse.put('$', "...-..-");
        textToMorse.put('@', ".--.-.");


        // Space between words
        textToMorse.put(' ', "/");


        // Reverse map: Morse to text
        for (Map.Entry<Character, String> entry : textToMorse.entrySet()) 
        {  morseToText.put(entry.getValue(), entry.getKey()); }

    }// closing public class MorseCodeConverter 


    //Function to convert Pargraph or Sentence to Morse code
    public static String convertTextToMorse(String text) 
    {
        StringBuilder morse = new StringBuilder();
        text = text.toUpperCase();

        for (int i = 0; i < text.length(); i++) 
        {
            char ch = text.charAt(i);

            if (textToMorse.containsKey(ch)) 
            {   morse.append(textToMorse.get(ch)).append(" ");  } 
            
            else 
            {  morse.append("? ");  }

        }//closing for loop i.e.for (int i = 0; i < text.length(); i++) 

        return morse.toString().trim();
    }//closing public static String convertTextToMorse(String text)

     
    //Function to convert Morse code to Paragraph or Sentence
    public static String convertMorseToText(String morse) 
    {
        StringBuilder text = new StringBuilder();
        String[] words = morse.trim().split(" / ");

        for (String word : words) 
        {
            String[] letters = word.split(" ");

            for (String letter : letters) 
            {
                if (morseToText.containsKey(letter)) 
                {  text.append(morseToText.get(letter)); } 
                
                else 
                {  text.append('?'); }

            }//closing for loop i.e. for (String letter : letters) 

            text.append(" ");

        }//closing for loop i.e. for (String word : words)

        return text.toString().trim();

    }//closing public static String convertMorseToText(String morse)


    public static boolean isMorseCode(String input) 
    { return input != null && input.trim().matches("[. /-]+"); }


    //Function for Text validation that allows letters, digits, spaces, and common punctuation
    public static boolean isValidText(String input) 
    {
        if (input == null || input.trim().isEmpty()) 
        {  return false;}

        // Allow A–Z, a–z, digits, space, and basic punctuation (.,?!'"()-)
        if (!input.trim().matches("[a-zA-Z0-9 ,.?!'\"()\\-]+")) 
        {  return false;}

        // String[] words = input.trim().split("\\s+");
        // int validWordCount = 0;

        // for (String word : words) {
        //     String cleanWord = word.replaceAll("[0-9,.?!'\"()\\-]", "");
        //     if (cleanWord.matches("[a-zA-Z]{2,}")) {
        //         validWordCount++;
        //     }
        // }

        // // Require at least 2 real words so we still reject very short/gibberish input
        // return validWordCount >= 2;

        //return input.trim().matches("[a-zA-Z0-9 ,.?!'\"()\\-]+");

        return input.trim().matches(".*[a-zA-Z].*"); 

    }//public static boolean isValidText(String input) 


    //Function to validate Morse code 
    public static boolean isValidMorseCode(String input) 
    {
        if (input == null || input.trim().isEmpty() || !input.trim().matches("[. /-]+")) 
        {  return false; }

        String[] words = input.trim().split(" / ");

        for (String word : words) 
        {
            String[] letters = word.split(" ");

            for (String letter : letters) 
            {
                if (!morseToText.containsKey(letter)) 
                { return false; }
            }//closing for loop i.e. for (String letter : letters)

        }//closing for loop i.e. for (String word : words)
        return true;

    }//closing public static boolean isValidMorseCode(String input) 


     //Tester class with main method to run the Morse code converter
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int choice;

        do 
        {
            System.out.println("\n===== MORSE CODE CONVERTER =====");
            System.out.println("1. Convert paragraph to Morse code");
            System.out.println("2. Convert Morse code to paragraph");
            System.out.println("3. Exit");
            System.out.print("\nEnter your choice: ");

            while (!sc.hasNextInt()) 
            {
                System.out.print("\nPlease enter a valid number (1-3): ");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) 
            {
                case 1: //Converting Paragraph or Sentence to Morse code
                System.out.println("""
    \nNote: 
    When entering a paragraph or sentence, use letters (A-Z, a-z), digits (0-9), spaces, and punctuation marks (.,?!'"()-).
    """);
                
                    System.out.println("Enter a paragraph or sentence:");
                    String paragraph = sc.nextLine();

                    if (!isValidText(paragraph) || isMorseCode(paragraph)) 
                    {  System.out.println("\nPlease enter valid paragraph or valid sentence.");} 
                    
                    else 
                    {
                        String morse = convertTextToMorse(paragraph);
                        System.out.println("\nMorse Code:");
                        System.out.println(morse);
                    }

                    break;

                case 2://Converting Morse code to Paragraph or Sentence
                     System.out.println("""
    \nNote: 
    Use single space between letters and ' / ' (there should be space before and after the slash) between words to type the Morse code
    """);
                    System.out.println("Enter Morse code:");
                    String morseInput = sc.nextLine();

                    if (!isMorseCode(morseInput)) 
                    {  System.out.println("\nError: Please enter Morse code.");   } 
                    
                    else if (!isValidMorseCode(morseInput)) 
                    {  System.out.println("\nPlease enter a valid morse code."); }
                    
                    else 
                    {
                        String text = convertMorseToText(morseInput);
                        System.out.println("\nConverted Paragraph or Converted Sentence:");
                        System.out.println(text);
                    }
                    break;

                case 3://To exit the program
                    System.out.println("\nThank you. Exiting program...");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please select 1, 2, or 3.");

            }//closing switch case

        } while (choice != 3); //closing do-while loop

        sc.close();

    }//closing public static void main(String[] args) i.e. the tester class 

}//public class MorseCodeConverter 