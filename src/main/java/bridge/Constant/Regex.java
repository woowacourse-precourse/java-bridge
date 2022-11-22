package bridge.Constant;

public enum Regex {

    NUMBER("\\d+");

    private final String regex;

    Regex(String regex) {
        this.regex = regex;
    }

    public String verify() {
        return regex;
    }
}
