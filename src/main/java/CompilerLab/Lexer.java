package CompilerLab;
import java.util.ArrayList;

public class Lexer {
    final String[] k_types = new String[]{
            "abstract", "final", "static",
            "private", "public", "char",
            "double", "boolean", "float",
            "void"
    };
    final char[] word_separators = new char[]{
            // whitespace
            ' ',
            // quotation mark
            '"'
    };
    final char[] operators = new char[]{
            // operators
            '+', '-', '/', '*', '%', '=',
            '<', '>'
    };
    final char[] delimiters = new char[]{
            // delimiters
            '(', ')', '{', '}', ';'
    };

    final String[] keywords = new String[]{
            "for", "if"
    };

    private String text;
    private static Lexer instance = null;
    private Lexer(){}
    public static Lexer getInstance(){
        if(instance == null){
            instance = new Lexer();
        }
        return instance;
    }

    public void setText(String text){
        this.text = text;
    }

    public ArrayList<Token> run() {
        ArrayList<Token> tokens = new ArrayList<>();
        String[] lines = text.split("\n");
        StringBuilder word = new StringBuilder();
        // Looping through each line
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            // Looping through each character
            for(int j = 0; j < line.length(); j++){
                boolean isWordChar = true;
                // Check if character is delimiter
                if(char_is_part_of_list(line.charAt(j), delimiters)){
                    isWordChar = false;
                    // Check for prior word
                    if(word.length() != 0){
                        // Check if word is k-type
                        if(is_In_String_Arr(word.toString(), k_types)){
                            Token token = new Token(word.toString(), "k-type");
                            tokens.add(token);
                            word = new StringBuilder();
                        }
                        // Check if word is a number
                        else if(isNumber(word.toString())){
                            Token token = new Token(word.toString(), "number");
                            tokens.add(token);
                            word = new StringBuilder();
                        }
                        // Check if word is a keyword
                        else if(is_In_String_Arr(word.toString(), keywords)){
                            Token token = new Token(word.toString(), "keyword");
                            tokens.add(token);
                            word = new StringBuilder();
                        }
                        // Word is id
                        else{
                            Token token = new Token(word.toString(), "id");
                            tokens.add(token);
                            word = new StringBuilder();
                        }
                    }
                    // Appending delimiter
                    word.append(line.charAt(j));
                    Token token = new Token(word.toString(), word.toString());
                    tokens.add(token);
                    word = new StringBuilder();
                }

                // Check if character is operator
                if(char_is_part_of_list(line.charAt(j), operators)){
                    isWordChar = false;
                    // Check for prior word
                    if(word.length() != 0){
                        // Check if word is k-type
                        if(is_In_String_Arr(word.toString(), k_types)){
                            Token token = new Token(word.toString(), "k-type");
                            tokens.add(token);
                            word = new StringBuilder();
                        }
                        // Check if word is a number
                        else if(isNumber(word.toString())){
                            Token token = new Token(word.toString(), "number");
                            tokens.add(token);
                            word = new StringBuilder();
                        }
                        // Check if word is a keyword
                        else if(is_In_String_Arr(word.toString(), keywords)){
                            Token token = new Token(word.toString(), "keyword");
                            tokens.add(token);
                            word = new StringBuilder();
                        }
                        // Word is id
                        else{
                            Token token = new Token(word.toString(), "id");
                            tokens.add(token);
                            word = new StringBuilder();
                        }
                    }
                    // Appending operator
                    word.append(line.charAt(j));
                    Token token = new Token(word.toString(), word.toString());
                    tokens.add(token);
                    word = new StringBuilder();
                }

                // Check if character is a word separator
                if(char_is_part_of_list(line.charAt(j), word_separators)){
                    isWordChar = false;
                    // Check for prior word
                    if(word.length() != 0){
                        // Check if word is k-type
                        if(is_In_String_Arr(word.toString(), k_types)){
                            Token token = new Token(word.toString(), "k-type");
                            tokens.add(token);
                            word = new StringBuilder();
                        }
                        // Check if word is a number
                        else if(isNumber(word.toString())){
                            Token token = new Token(word.toString(), "number");
                            tokens.add(token);
                            word = new StringBuilder();
                        }
                        // Check if word is a keyword
                        else if(is_In_String_Arr(word.toString(), keywords)){
                            Token token = new Token(word.toString(), "keyword");
                            tokens.add(token);
                            word = new StringBuilder();
                        }
                        // Word is id
                        else{
                            Token token = new Token(word.toString(), "id");
                            tokens.add(token);
                            word = new StringBuilder();
                        }
                    }
                }
                // Character is part of a word
                if(isWordChar){
                    word.append(line.charAt(j));
                }
            }
            // Check if we have a word left over
            if(word.length() != 0){
                // Check if word is k-type
                if(is_In_String_Arr(word.toString(), k_types)){
                    Token token = new Token(word.toString(), "k-type");
                    tokens.add(token);
                    word = new StringBuilder();
                }
                // Check if word is a number
                else if(isNumber(word.toString())){
                    Token token = new Token(word.toString(), "number");
                    tokens.add(token);
                    word = new StringBuilder();
                }
                // Check if word is a keyword
                else if(is_In_String_Arr(word.toString(), keywords)){
                    Token token = new Token(word.toString(), "keyword");
                    tokens.add(token);
                    word = new StringBuilder();
                }
                // Word is id
                else{
                    Token token = new Token(word.toString(), "id");
                    tokens.add(token);
                    word = new StringBuilder();
                }
            }
        }
        return tokens;
    }

    public boolean is_In_String_Arr(String string, String[]arr){
        for(String element: arr){
            if(string.equals(element)){
                return true;
            }
        }
        return false;
    }

    public boolean isNumber(String string){
        try {
            Double.parseDouble(string);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public boolean char_is_part_of_list(char character, char[] list){
        for(char listChar: list){
            if(character == listChar){
                return true;
            }
        }
        return false;
    }

}
