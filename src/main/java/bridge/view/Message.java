package bridge.view;

public enum Message {
    MESSAGE_BEGINNING("다리 건너기 게임을 시작합니다."),

    INPUT_MESSAGE_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    INPUT_MESSAGE_MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_MESSAGE_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),

    ERROR_MESSAGE_BRIDGE_LENGTH("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ERROR_MESSAGE_MOVING("[ERROR] 이동할 칸은 U 또는 D가 입력되어야 합니다."),

    ERROR_MESSAGE_GAME_COMMAND("[ERROR] 게임 재시도 여부는 R 또는 Q 가 입력되어야 합니다."),

    RESULT_MESSAGE("최종 게임 결과"),
    RESULT_MESSAGE_IS_SUCCESS("게임 성공 여부: "),
    RESULT_MESSAGE_TOTAL_ATTEMPT("총 시도한 횟수: ");



    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
