# Morse Code Converter
  
## Description
A Java-based console application that facilitates bidirectional communication between plain text and Morse code. The program leverages core Java Collections and Regular Expressions to provide an efficient, error-resistant translation tool for educational or recreational use.


## How the Code Works
The Morse Code Converter is built using a procedural approach within a structured class, focusing on data mapping and string manipulation. It utilizes dual HashMap structures to ensure $O(1)$ time complexity for character lookups.

➤ **Core Architecture and Logic** <br>
The application is structured to handle data initialization and processing through three main phases:

   - **Static Initialization:** The code uses a static block to pre-populate the textToMorse map. Once the text map is filled, it programmatically generates the morseToText map by iterating through the entry set, ensuring the two maps are always perfectly synchronized.

   - **Text-to-Morse Logic:** The convertTextToMorse method converts the input to uppercase to match the map keys. It iterates through each character, appending the corresponding Morse string followed by a space. If a character is not recognized, by defualt it will print "Please enter valid paragraph or valid sentence."

   - **Morse-to-Text Logic**: This method uses a nested splitting strategy. It first splits the input by / to identify words, then splits those results by spaces to identify individual letters. This ensures the original sentence structure (spaces between words) is preserved upon translation.

 
