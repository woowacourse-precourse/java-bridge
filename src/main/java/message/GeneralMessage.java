package message;

public enum GeneralMessage {
    GAME_START("다리 건너기 게임을 시작합니다.\n\n"),
    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    SELECT_UP_OR_DOWN("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT("최종 게임 결과"),
    SUCCESS_OR_NOT("게임 성공 여부: "),
    NUMBER_OF_TRY("총 시도한 횟수: ");

    private String message;

    GeneralMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
