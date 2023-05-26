package CompilerLab_Test;

import CompilerLab.Parser;
import CompilerLab.Token;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParserTest {

    Parser parse = new Parser();
    @Test
    public void parserMethodForTestingTestAllGood() {
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

        Assertions.assertTrue(parse.parserMethodForTesting(test));
    }

    @Test
    public void parserMethodForTestingTestEmpty() {
        ArrayList<Token> test = new ArrayList<>();

        Assertions.assertFalse(parse.parserMethodForTesting(test));
    }

    @Test
    public void parserMethodForTestingTestWrongOrder() {
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

        Assertions.assertFalse(parse.parserMethodForTesting(test));
    }

    @Test
    public void parserMethodForTestingTestWrongType() {
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

        Assertions.assertFalse(parse.parserMethodForTesting(test));
    }



}
