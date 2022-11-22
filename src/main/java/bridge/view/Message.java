package bridge.view;

public enum Message {
    INITIAL_MESSAGE("다리 건너기 게임을 시작합니다.\n"),
    REQUEST_BRIDGE_SIZE("다리의 길이를 입력해주세요."),

    REQUEST_MOVEMENT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    REQUEST_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_RESULT("최종 게임 결과"),
    FAIL_TRY_COUNT("게임 성공 여부: 성공\n총 시도한 횟수: "),
    SUCCESS_TRY_COUNT("게임 성공 여부: 실패\n총 시도한 횟수: "),
    ;

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
