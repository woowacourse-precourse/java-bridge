package bridge.enums;

public enum OutputViewMessage {
    GAME_START("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    SELECT_BRIDGE_LOCATION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    SELECT_GAME_RESTART("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT("최종 게임 결과"),
    GAME_SUCCESS_OR_FAILURE("게임 성공 여부: "),
    GAME_PLAYTIME("총 시도한 횟수: "),
    SUCCESS("성공"),
    FAILURE("실패");


    private final String message;

    private OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
