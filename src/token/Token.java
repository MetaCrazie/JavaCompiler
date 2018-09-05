package token;

/**
 * The {@code Token} class represents token (lexeme). A token is a string of
 * characters, categorized according to the rules as a symbol. For example: <i>
 * Identifier, Comma, DoubleConstant</i>.
 */

public class Token {

    private int beginIndex;
    private int endIndex;
    private TokenType tokenType;
    private String tokenString;

    public Token(int beginIndex, int endIndex, String tokenString, TokenType tokenType) {
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.tokenType = tokenType;
        this.tokenString = tokenString;
    }

    public int getBegin() {
        return beginIndex;
    }

    public int getEnd() {
        return endIndex;
    }

    public String getTokenString() {
        return tokenString;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    @Override
    public String toString() {
        if (!this.getTokenType().isAuxiliary())
            return tokenType + "  '" + tokenString + "' [" + beginIndex + ";" + endIndex + "] ";
        else
            return tokenType + "   [" + beginIndex + ";" + endIndex + "] ";
    }
}