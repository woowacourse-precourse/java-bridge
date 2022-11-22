package bridge.type;

public enum TextType {

    UP("U"),
    DOWN("D"),
    RESTART("R"),
    EXIT("Q"),
    START_MESSAGE("다리 건너기 게임을 시작합니다."),
    BRIDGE_START("[ "),
    BRIDGE_END(" ]"),
    BRIDGE_MID(" | "),
    POSSIBLE_SPACE("O"),
    IMPOSSIBLE_SPACE("X");

    private final String text;

    TextType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
