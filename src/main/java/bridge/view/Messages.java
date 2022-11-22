package bridge.view;

public enum Messages {
    // for inputView
    SCAN_BRIDGE_SIZE("\n다리의 길이를 입력해주세요."),
    SCAN_MOVING_COMMAND("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    SCAN_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    // for outputView
    PRINT_GAME_START("다리 건너기 게임을 시작합니다."),
    PRINT_FINAL_RESULT("최종 게임 결과"),
    PRINT_SUCCESS("게임 성공 여부: 성공"),
    PRINT_FAILURE("게임 성공 여부: 실패"),
    PRINT_NUMBER_OF_ATTEMPTS("총 시도한 횟수: %d\n")
    ;

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
