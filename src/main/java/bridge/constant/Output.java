package bridge.constant;

public enum Output {
    INIT_START("다리 건너기 게임을 시작합니다.\n"),
    SET_SIZE("다리의 길이를 입력해주세요."),
    RESTART("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),

    RESULT("최종 게임 결과"),
    RESULT_IS_SUCCESS("게임 성공 여부: "),
    RESULT_GAME_COUNT("총 시도한 횟수: ");

    private String showPrint;

    Output(String showPrint) {
        this.showPrint = showPrint;
    }

    public String getPrint() {
        return showPrint;
    }

}
