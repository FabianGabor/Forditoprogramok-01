package hu.nye.forditoprogramok;

public enum TokenType {
    AZONOSITO("[a-zA-Z]+[0-9]+|[a-zA-Z]+"),
    ERTEKADAS(":="),
    KOMMENTAR("(\\(\\*\\*)(.*)(?=(\\*\\*\\)))|\\{(.*)(?=(\\}))"),
    //KOMMENTAR("(?<=(\\(\\*\\*))(.*)(?=(\\*\\*\\)))"),
    //BETU("[a-z,A-Z]"),
    //SZO("[a-z,A-Z]+"),
    SZAM("-?[0-9]+"),
    //OPERATOR("[*|/|+|-]"),
    NAGYOBBEGYENLO(">="),
    KISEBBEGYENLO("=<"),
    KIHAGY("[ \t\f\r\n]+"),
    VEGE("\\$");

    public final String pattern;

    TokenType(String pattern) {
        this.pattern = pattern;
    }
}
