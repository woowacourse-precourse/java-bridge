package bridge.io;

public enum Message {
    START("다리 건너기 게임을 시작합니다.\n다리의 길이를 입력해주세요."),
    REQUEST_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RESTART_OR_EXIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    SPLIT(" | "),
    ROUTE("[ %s ]\n"),
    INPUT_ERROR("[ERROR] 올바른 입력 형식이 아닙니다."),
    END("최종 게임 결과"),
    RESULT("게임 성공 여부: %s\n총 시도한 횟수: %d"),
    SUCCESS("성공"),
    FAIL("실패");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
