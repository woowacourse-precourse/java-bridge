package bridge.constants;

public enum GuideMessage {
    START_MESSAGE("다리 건너기 게임을 시작합니다.\n"),
    INPUT_LENGTH_MESSAGE("다리의 길이를 입력해주세요.\n"),
    INPUT_MOVE_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)\n"),
    RESTART_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n"),
    FINAL_RESULT_MESSAGE("최종 게임 결과\n"),
    SUCCESS_OR_FAILURE_MESSAGE("\n게임 성공 여부: "),
    TOTAL_TRY_MESSAGE("총 시도한 횟수: ");

    private final String message;

    GuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
