package CompilerLab;

public class Token {
    private String words;
    private String type;

    public Token(String words, String type) {
        this.words = words;
        this.type = type;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
