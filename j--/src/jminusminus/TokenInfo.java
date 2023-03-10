// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

// This file was modified for use in the DTU course 02247 Compiler Construction

package jminusminus;

/**
 * An enum of token kinds. Each entry in this enum represents the kind of a
 * token along with its image (string representation).
 * <p>
 * When you add a new token to the scanner, you must also add an entry to this
 * enum specifying the kind and image of the new token.
 */

enum TokenKind {
    EOF("<EOF>"), 

    // Reserved words
    ABSTRACT("abstract"), BOOLEAN("boolean"), CHAR("char"), BREAK("break"), BYTE("byte"), CLASS("class"), 
    CASE("case"), CATCH("catch"), CONST("const"), CONTINUE("continue"), DEFAULT("default"), DO("do"), DOUBLE("double"),
    ELSE("else"), EXTENDS("extends"), FINAL("final"), FINALLY("finally"), FLOAT("float"), GOTO("goto"), IMPLEMENTS("implements"),
    INTERFACE("interface"), IF("if"), IMPORT("import"), 
    INSTANCEOF("instanceof"), INT("int"), LONG("long"), NATIVE("native"), NEW("new"), PACKAGE("package"), 
    PRIVATE("private"), PROTECTED("protected"), PUBLIC("public"), 
    RETURN("return"), SHORT("short"), STRICTFP("strictfp"), SWITCH("switch"), SYNCHRONIZED("synchronized"),
    STATIC("static"), SUPER("super"), THREADSAFE("threadsafe"), THROW("throw"), THROWS("throws"), TRANSIENT("transient"), TRY("try"), THIS("this"), 
    VOID("void"), VOLATILE("volatile"), FOR("for"), WHILE("while"), 

    // Comparators
    EQ("=="), NEQ("!="),
    LNOT("!"), LAND("&&"), LOR("||"),
    GT(">"), GE(">="),
    LT("<"), LE("<="), 

    // Operators
    DEC("--"), INC("++"),
    MINUS("-"), PLUS("+"), STAR("*"), DIV("/"), MOD("%"),
    SHIFTR(">>"), USHIFTR(">>>"), SHIFTL("<<"),
    OR("|"), XOR("^"), AND("&"), TILDE("~"), TERNARY("?"),

    // Assign Operators
    ASSIGN("="), MINUS_ASSIGN("-="), PLUS_ASSIGN("+="), DIV_ASSIGN("/="), STAR_ASSIGN("*="), MOD_ASSIGN("%="), AND_ASSIGN("&="), XOR_ASSIGN("^="), OR_ASSIGN("|="), USHIFTR_ASSIGN(">>>="), SHIFTR_ASSIGN(">>="), SHIFTL_ASSIGN("<<="),

    // Separators
    LPAREN("("), RPAREN(")"), LCURLY("{"), RCURLY("}"), LBRACK("["), 
    RBRACK("]"), SEMI(";"), COLON(":"), COMMA(","), DOT("."),

    // Identifiers
    IDENTIFIER("<IDENTIFIER>"), 

    // Literals
    NULL("null"),
    FALSE("false"), TRUE("true"),
    INT_LITERAL("<INT_LITERAL>"),
    DOUBLE_LITERAL("<DOUBLE_LITERAL>"),
    CHAR_LITERAL("<CHAR_LITERAL>"), STRING_LITERAL("<STRING_LITERAL>");

    /** The token's string representation. */
    private String image;

    /**
     * Constructs an instance TokenKind given its string representation.
     * 
     * @param image
     *            string representation of the token.
     */

    private TokenKind(String image) {
        this.image = image;
    }

    /**
     * Returns the image of the token.
     * 
     * @return the token's image.
     */

    public String image() {
        return image;
    }

    /**
     * Returns the string representation of the token.
     * 
     * @return the token's string representation.
     */

    public String toString() {
        return image;
    }

}

/**
 * A representation of tokens returned by the lexical analyzer method,
 * {@link Scanner#getNextToken() getNextToken}. A token has a kind identifying 
 * what kind of token it is, an image for providing any semantic text, and the 
 * line in which it occurred in the source file.
 */

class TokenInfo {

    /** Token kind. */
    private TokenKind kind;

    /**
     * Semantic text (if any). For example, the identifier name when the token
     * kind is IDENTIFIER. For tokens without a semantic text, it is simply its
     * string representation. For example, "+=" when the token kind is
     * PLUS_ASSIGN.
     */
    private String image;

    /** Line in which the token occurs in the source file. */
    private int line;

    /**
     * Constructs a TokenInfo given its kind, the semantic text forming the token,
     * and its line number.
     * 
     * @param kind
     *            the token's kind.
     * @param image
     *            the semantic text comprising the token.
     * @param line
     *            the line in which the token occurs in the source file.
     */

    public TokenInfo(TokenKind kind, String image, int line) {
        this.kind = kind;
        this.image = image;
        this.line = line;
    }

    /**
     * Constructs a TokenInfo given its kind and its line number. Its image is
     * simply its string representation.
     * 
     * @param kind
     *            the token's identifying number.
     * @param line
     *            identifying the line on which the token was found.
     */

    public TokenInfo(TokenKind kind, int line) {
        this(kind, kind.toString(), line);
    }

    /**
     * Returns the token's string representation.
     * 
     * @return the string representation.
     */

    public String tokenRep() {
        return kind.toString();
    }

    /**
     * Returns the semantic text associated with the token.
     * 
     * @return the semantic text.
     */

    public String image() {
        return image;
    }

    /**
     * Returns the line number associated with the token.
     * 
     * @return the line number.
     */

    public int line() {
        return line;
    }

    /**
     * Returns the token's kind.
     * 
     * @return the kind.
     */

    public TokenKind kind() {
        return kind;
    }

    /**
     * Returns the token's image.
     * 
     * @return the image.
     */

    public String toString() {
        return image;
    }

}
