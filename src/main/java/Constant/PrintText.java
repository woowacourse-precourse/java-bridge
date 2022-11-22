package Constant;

public enum PrintText {
    GAME_START("다리 건너기 게임을 시작합니다."),
    BRIDGE_SIZE_INPUT("다리의 길이를 입력해주세요."),
    BRIDGE_MOVE_INPUT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RESTART_INPUT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT("최종 게임 결과"),
    ENDING_MESSAGE("게임 성공 여부: "),
    TRY_COUNT("총 시도한 횟수: ");

    private final String text;
    PrintText(String s) {
        this.text = s;
    }

    public String getText(){
        return text;
    }

}
