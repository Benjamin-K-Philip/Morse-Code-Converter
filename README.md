# Morse Code Converter
  
## Description
A Java-based console application that facilitates bidirectional communication between plain text and Morse code. The program leverages core Java Collections and Regular Expressions to provide an efficient, error-resistant translation tool for educational or recreational use.

---


## How the Code Works
The Morse Code Converter is built using a procedural approach within a structured class, focusing on data mapping and string manipulation. It utilizes dual HashMap structures to ensure $O(1)$ time complexity for character lookups.

➤ **Core Architecture and Logic** <br>
The application is structured to handle data initialization and processing through three main phases:

   - **Static Initialization:** The code uses a static block to pre-populate the textToMorse map. Once the text map is filled, it programmatically generates the morseToText map by iterating through the entry set, ensuring the two maps are always perfectly synchronized.

   - **Text-to-Morse Logic:** The convertTextToMorse method converts the input to uppercase to match the map keys. It iterates through each character, appending the corresponding Morse string followed by a space. If a character is not recognized, by defualt it will print "Please enter valid paragraph or valid sentence."

   - **Morse-to-Text Logic**: This method uses a nested splitting strategy. It first splits the input by / to identify words, then splits those results by spaces to identify individual letters. This ensures the original sentence structure (spaces between words) is preserved upon translation.


 ➤ **Implementation of Programming Concepts** <br>
The code serves as a practical demonstration of several fundamental Java concepts:

   - **Collections Framework:** Uses HashMap for lightning-fast bidirectional lookups between characters and Morse sequences.

   - **String Manipulation:** Extensively uses StringBuilder for memory-efficient string concatenation and split() for parsing Morse patterns.

   - **Data Validation (Regex):** Employs Regular Expressions (e.g., [a-zA-Z0-9 ,.?!'\"()\\-]+) to validate user input and differentiate between plain text and Morse code symbols.

   - **Input Handling:** Implements a do-while loop with a switch statement to create a persistent, user-friendly command-line interface (CLI).


---


## Features
  - **Bidirectional Translation:** Convert paragraphs of text to Morse code and vice versa.

  - **Comprehensive Character Support:** Includes support for the full English alphabet, numbers 0-9, and extensive punctuation (like .,?!' "()-).

  - **Input Sanitization:** Automatically detects if the input is valid for the chosen mode and handles unrecognized symbols with a placeholder (?).

  - **Preserved Formatting:** Maintains word spacing using the standard / delimiter, ensuring translated text remains readable.

--- 


## Project Structure
  - **Logic (MorseCodeConverter.java):** Contains the primary conversion methods (convertTextToMorse, convertMorseToText) and the static lookup maps.

  - **Validation:** Includes helper methods like isValidMorseCode and isValidText to prevent runtime errors during processing.

  - **UI (Main Method):** The entry point that manages the console menu and user interaction.

---


## Output
