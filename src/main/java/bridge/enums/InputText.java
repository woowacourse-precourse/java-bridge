package bridge.enums;

public enum InputText {
    GAME_START_TEXT("다리 건너기 게임을 시작합니다."),
    BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    MOVE_TO("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    QUIT_OR_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private String text;

    InputText(String text) {
        this.text = text;
    }

    public String getValue() {
        return this.text;
    }
}
