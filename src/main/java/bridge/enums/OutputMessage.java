package bridge.enums;

public enum OutputMessage {
    OUTPUT_START_BRIDGE_GAME("다리 건너기 게임을 시작합니다."),
    OUTPUT_ENTER_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    OUTPUT_CHOOSE_BRIDGE_MOVE_POSITION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    OUTPUT_CHOOSE_RESTART_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    OUTPUT_FINAL_BRIDGE_GAME_RESULT("최종 게임 결과"),
    OUTPUT_GAME_SUCCESS_RESULT("게임 성공 여부: %s"),
    OUTPUT_TOTAL_TRY_GAME_TIMES("총 시도한 횟수: %d");

    final private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
