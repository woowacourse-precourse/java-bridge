package bridge.Constant;

public enum Regex {

    NUMBER("\\d+"),
    THREE_TO_TWENTY("^[3-9]{1}|^[1]{1}[0-9]{1}|^[2]{1}[0]{1}"); //3~20 사이의 숫자만

    private final String regex;

    Regex(String regex) {
        this.regex = regex;
    }

    public String verify() {
        return regex;
    }
}
