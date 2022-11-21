package bridge.enums;

public enum ErrorText {
    BRIDGE_SIZE_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVE_TO_ERROR("[ERROR] 이동할 칸은 U이거나 D이여야 합니다."),
    QUIT_ERROR("[ERROR] 게임 재시도 여부는 R이나 Q이여야 합니다.");

    private String text;

    ErrorText(String text) {
        this.text = text;
    }

    public String getValue() {
        return this.text;
    }
}
