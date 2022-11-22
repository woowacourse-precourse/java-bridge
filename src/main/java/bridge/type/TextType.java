package bridge.type;

public enum TextType {

    UP("U"),
    DOWN("D"),
    RESTART("R"),
    EXIT("Q"),
    START_MESSAGE("다리 건너기 게임을 시작합니다.");

    private final String text;

    TextType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
