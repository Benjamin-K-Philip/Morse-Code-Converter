import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCodeConverter {

    private static final Map<Character, String> textToMorse = new HashMap<>();
    private static final Map<String, Character> morseToText = new HashMap<>();

    static {
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

        // Special characters / punctuation
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
        for (Map.Entry<Character, String> entry : textToMorse.entrySet()) {
            morseToText.put(entry.getValue(), entry.getKey());
        }
    }

    public static String convertTextToMorse(String text) {
        StringBuilder morse = new StringBuilder();

        text = text.toUpperCase();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (textToMorse.containsKey(ch)) {
                morse.append(textToMorse.get(ch)).append(" ");
            } else {
                morse.append("? ");
            }
        }

        return morse.toString().trim();
    }

    public static String convertMorseToText(String morse) {
        StringBuilder text = new StringBuilder();

        String[] words = morse.trim().split(" / ");

        for (String word : words) {
            String[] letters = word.split(" ");

            for (String letter : letters) {
                if (morseToText.containsKey(letter)) {
                    text.append(morseToText.get(letter));
                } else {
                    text.append('?');
                }
            }
            text.append(" ");
        }

        return text.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MORSE CODE CONVERTER =====");
            System.out.println("1. Convert paragraph to Morse code");
            System.out.println("2. Convert Morse code to paragraph");
            System.out.println("3. Exit");
            System.out.print("\nEnter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("\nPlease enter a valid number (1-3): ");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nEnter a paragraph:");
                    String paragraph = sc.nextLine();
                    String morse = convertTextToMorse(paragraph);
                    System.out.println("\nMorse Code:");
                    System.out.println(morse);
                    break;

                case 2:
                    System.out.println("\nEnter Morse code:");
                    System.out.println("(Note: Use single space between letters and ' / ' between words to type the Morse code)");
                    String morseInput = sc.nextLine();
                    String text = convertMorseToText(morseInput);
                    System.out.println("\nConverted Paragraph:");
                    System.out.println(text);
                    break;

                case 3:
                    System.out.println("\nThank you.Exiting program...");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please select 1, 2, or 3.");
            }

        } while (choice != 3);

        sc.close();
    }
}