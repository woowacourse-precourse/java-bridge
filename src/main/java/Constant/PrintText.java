package Constant;

public enum PrintText {
    GAME_START("다리 건너기 게임을 시작합니다."),
    BRIDGE_SIZE_INPUT("다리의 길이를 입력해주세요."),
    BRIDGE_MOVE_INPUT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GAME_RESTART("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String text;
    PrintText(String s) {
        this.text = s;
    }

    public String getText(){
        return text;
    }

}
