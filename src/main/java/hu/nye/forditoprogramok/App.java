package hu.nye.forditoprogramok;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        final String CODE = "12azonosito12:=(**komment**){komment}>=azonosito";

        Tokenizer tokenizer = new Tokenizer(CODE);
        List<Token> tokens = tokenizer.getTokens();

        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}
