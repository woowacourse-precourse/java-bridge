package bridge.view.enumeration;

public enum Format {
    CORRECT(" O "),
    WRONG(" X "),
    EMPTY("   "),
    SEPARATOR("|"),
    FIRST_BRACKET("["),
    LAST_BRACKET("]");

    private final String format;

    Format(String format){
        this.format = format;
    }

    public String getFormat(){
        return this.format;
    }
}
