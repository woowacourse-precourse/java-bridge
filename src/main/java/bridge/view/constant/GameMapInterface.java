package bridge.view.constant;

public enum GameMapInterface {
    MAP_BRACKET("[ %s ]"),
    MAP_SEPARATOR(" | ");

    private final String value;

    GameMapInterface(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getBracketString(String input) {
        return String.format(value, input);
    }

}
