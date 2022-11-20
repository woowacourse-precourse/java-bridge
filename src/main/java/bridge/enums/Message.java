package bridge.enums;

public enum Message {
    START_GAME("다리 건너기 게임을 시작합니다."),
    ASK_LENGTH("다리의 길이를 입력해주세요."),
    ASK_STEP("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    ASK_RESTART("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    PRINT_RESULT("최종 게임 결과"),
    WHETHER_SUCCESS("게임 성공 여부: "),
    SUCCESS_RESULT("성공"),
    FAIL_RESULT("실패"),
    TOTAL_TRIAL("총 시도한 횟수:");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
