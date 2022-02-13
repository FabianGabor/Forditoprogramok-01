package hu.nye.forditoprogramok;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    private final String code;
    private List<Token> tokens;

    public Tokenizer(String code) {
        this.code = code;
        tokenize();
    }

    public List<Token> getTokens() {
        return tokens;
    }

    private void tokenize() {
        tokens = new ArrayList<>();

        Pattern tokenPatterns = getPatterns();

        Matcher matcher = tokenPatterns.matcher(code);
        matchTokens(matcher);
    }

    private Pattern getPatterns() {
        StringBuilder tokenPatternsBuilder = new StringBuilder();
        for (TokenType token : TokenType.values())
            tokenPatternsBuilder.append(String.format("|(?<%s>%s)", token.name(), token.pattern));
        return Pattern.compile(tokenPatternsBuilder.substring(1));
    }

    private void matchTokens(Matcher matcher) {
        while (matcher.find()) {
            for (TokenType token : TokenType.values())
                if (matcher.group(token.name()) != null) {
                    tokens.add(new Token(token, matcher.group(token.name())));
                }
        }
    }
}
