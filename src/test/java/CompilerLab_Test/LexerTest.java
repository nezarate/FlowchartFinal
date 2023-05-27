package CompilerLab_Test;


import CompilerLab.Lexer;
import CompilerLab.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;


public class LexerTest {
    @Test
    public void lexerText1(){
        String input = "void student (){\n" +
                "}";
        ArrayList<Token> expected = new ArrayList<>();
        expected.add(new Token("void", "k-type"));
        expected.add(new Token("student", "id"));
        expected.add(new Token("(", "("));
        expected.add(new Token(")", ")"));
        expected.add(new Token("{", "{"));
        expected.add(new Token("}", "}"));
        Lexer.getInstance().setText(input);
        ArrayList<Token> tokens = Lexer.getInstance().run();
        for(int i = 0; i < expected.size(); i++){
            Assertions.assertEquals(expected.get(i).getType(), tokens.get(i).getType());
            Assertions.assertEquals(expected.get(i).getWords(), tokens.get(i).getWords());
        }
    }
    @Test
    public void lexerText2(){
        String input = "void student (){\n" +
                "Hello_world();" +
                "}";
        ArrayList<Token> expected = new ArrayList<>();
        expected.add(new Token("void", "k-type"));
        expected.add(new Token("student", "id"));
        expected.add(new Token("(", "("));
        expected.add(new Token(")", ")"));
        expected.add(new Token("{", "{"));
        expected.add(new Token("Hello_world", "id"));
        expected.add(new Token("(", "("));
        expected.add(new Token(")", ")"));
        expected.add(new Token(";", ";"));
        expected.add(new Token("}", "}"));
        Lexer.getInstance().setText(input);
        ArrayList<Token> tokens = Lexer.getInstance().run();
        for(int i = 0; i < expected.size(); i++){
            Assertions.assertEquals(expected.get(i).getType(), tokens.get(i).getType());
            Assertions.assertEquals(expected.get(i).getWords(), tokens.get(i).getWords());
        }
    }

    @Test
    public void lexerText3(){
        String input = "void student (){\n" +
                "Hello world;" +
                "}";
        ArrayList<Token> expected = new ArrayList<>();
        expected.add(new Token("void", "k-type"));
        expected.add(new Token("student", "id"));
        expected.add(new Token("(", "("));
        expected.add(new Token(")", ")"));
        expected.add(new Token("{", "{"));
        expected.add(new Token("Hello", "id"));
        expected.add(new Token("world", "id"));
        expected.add(new Token(";", ";"));
        expected.add(new Token("}", "}"));
        Lexer.getInstance().setText(input);
        ArrayList<Token> tokens = Lexer.getInstance().run();
        for(int i = 0; i < expected.size(); i++){
            Assertions.assertEquals(expected.get(i).getType(), tokens.get(i).getType());
            Assertions.assertEquals(expected.get(i).getWords(), tokens.get(i).getWords());
        }
    }

    @Test
    public void lexerText4(){
        String input = "int x;\n" +
                "void student () {\n" +
                "world();\n" +
                "for (int x=0; x < 10; x++) {\n" +
                "hello(); x=x+1; break;\n" +
                "}\n" +
                "}";
        ArrayList<Token> expected = new ArrayList<>();
        expected.add(new Token("int", "k-type"));
        expected.add(new Token("x", "id"));
        expected.add(new Token(";", ";"));
        expected.add(new Token("void", "k-type"));
        expected.add(new Token("student", "id"));
        expected.add(new Token("(", "("));
        expected.add(new Token(")", ")"));
        expected.add(new Token("{", "{"));
        expected.add(new Token("world", "id"));
        expected.add(new Token("(", "("));
        expected.add(new Token(")", ")"));
        expected.add(new Token(";", ";"));
        expected.add(new Token("for", "keyword"));
        expected.add(new Token("(", "("));
        expected.add(new Token("int", "k-type"));
        expected.add(new Token("x", "id"));
        expected.add(new Token("=", "="));
        expected.add(new Token("0", "number"));
        expected.add(new Token(";", ";"));
        expected.add(new Token("x", "id"));
        expected.add(new Token("<", "<"));
        expected.add(new Token("10", "number"));
        expected.add(new Token(";", ";"));
        expected.add(new Token("x", "id"));
        expected.add(new Token("+", "+"));
        expected.add(new Token("+", "+"));
        expected.add(new Token(")", ")"));
        expected.add(new Token("{", "{"));
        expected.add(new Token("hello", "id"));
        expected.add(new Token("(", "("));
        expected.add(new Token(")", ")"));
        expected.add(new Token(";", ";"));
        expected.add(new Token("x", "id"));
        expected.add(new Token("=", "="));
        expected.add(new Token("x", "id"));
        expected.add(new Token("+", "+"));
        expected.add(new Token("1", "number"));
        expected.add(new Token(";", ";"));
        expected.add(new Token("break", "id"));
        expected.add(new Token(";", ";"));
        expected.add(new Token("}", "}"));
        expected.add(new Token("}", "}"));

        Lexer.getInstance().setText(input);
        ArrayList<Token> tokens = Lexer.getInstance().run();
        for(int i = 0; i < expected.size(); i++){
            Assertions.assertEquals(expected.get(i).getType(), tokens.get(i).getType());
            Assertions.assertEquals(expected.get(i).getWords(), tokens.get(i).getWords());
        }
    }

}

