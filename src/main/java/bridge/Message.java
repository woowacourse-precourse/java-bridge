package bridge;

public enum Message {
    PRINT_START("다리 건너기 게임을 시작합니다."),
    PRINT_FINAL_RESULT("최종 게임 결과"),
    PRINT_IS_SUCCESSFUL("게임 성공 여부: "),
    PRINT_NUMBER_OF_ATTEMPTS("총 시도한 횟수: "),
    PRINT_SELECT_THE_CELL_TO_MOVE("이동할 칸을 선택해주세요"),
    PRINT_RETRY_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    PRINT_INPUT_SIZE_BRIDGE("다리의 길이를 입력해주세요."),
    FAIL("실패"),
    SUCCESS("성공")
    ;



    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
