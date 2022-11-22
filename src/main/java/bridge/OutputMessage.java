package bridge;

public enum OutputMessage {
    START_MESSAGE("다리 건너기 게임을 시작합니다.\n"),
    BRIDGE_LENGTH_MESSAGE("다리의 길이를 입력해주세요."),
    CHOICE_REQUEST_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RESTART_OR_QUIT_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT_MESSAGE("최종 게임 결과"),
    SUMMARY_MESSAGE("게임 성공 여부: %s\n총 시도한 횟수: %d");
    private final String message;
    OutputMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return (message);
    }
}
