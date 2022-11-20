package bridge.util;

public enum MessageConstant {
    ERROR_BRIDGE_LENGTH("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ERROR_EMPTY("[ERROR] 입력이 비어있습니다."),
    ERROR_INPUT_DIRECTION("[ERROR] U(위) 또는 D(아래)만을 입력해야 합니다."),
    ERROR_INPUT_GAME_CONTINUOUS("[ERROR] R(재시도) 또는 Q(종료)만을 입력해야 합니다."),

    SELECT_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),

    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),

    START_GAME("다리 건너기 게임을 시작합니다.\n"),

    TOTAL_RESULT("최종 게임 결과"),

    SUCCESS_OR_NOT("게임 성공 여부: "),

    TRY_COUNT("총 시도한 횟수: "),
    SUCCESS("성공"),
    FAIL("실패");
    private final String message;

    MessageConstant(String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }
}
