package CompilerLab_Test;

import CompilerLab.Parser;
import CompilerLab.Token;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParserTest {

    Parser parse = new Parser();
    @Test
    public void parserMethodTestAllGood() {
        ArrayList<Token> test = new ArrayList<>();
        test.add(new Token("void","k-type"));
        test.add(new Token("method","id"));
        test.add(new Token("(","("));
        test.add(new Token(")",")"));
        test.add(new Token("{","{"));
        test.add(new Token("int","k-type"));
        test.add(new Token("x","id"));
        test.add(new Token("=","operator"));
        test.add(new Token("5","number"));
        test.add(new Token(";",";"));
        test.add(new Token("}","}"));

        Assertions.assertTrue(parse.parserMethod(test));
    }

    @Test
    public void parserMethodTestEmpty() {
        ArrayList<Token> test = new ArrayList<>();

        Assertions.assertTrue(parse.parserMethod(test));
    }

    @Test
    public void parserMethodTestWrongOrder() {
        ArrayList<Token> test = new ArrayList<>();
        test.add(new Token("void","k-type"));
        test.add(new Token("method","id"));
        test.add(new Token(")",")"));
        test.add(new Token("(","("));
        test.add(new Token("{","{"));
        test.add(new Token("int","k-type"));
        test.add(new Token("x","id"));
        test.add(new Token("=","operator"));
        test.add(new Token("5","number"));
        test.add(new Token(";",";"));
        test.add(new Token("}","}"));

        Assertions.assertFalse(parse.parserMethod(test));
    }

    @Test
    public void parserMethodTestWrongType() {
        ArrayList<Token> test = new ArrayList<>();
        test.add(new Token("void","k-type"));
        test.add(new Token("method","id-name"));
        test.add(new Token(")",")"));
        test.add(new Token("(","("));
        test.add(new Token("{","{"));
        test.add(new Token("int","k-type"));
        test.add(new Token("x","id"));
        test.add(new Token("=","operator"));
        test.add(new Token("5","number"));
        test.add(new Token(";",";"));
        test.add(new Token("}","}"));

        Assertions.assertFalse(parse.parserMethod(test));
    }



}
