package bridge.constant.message;

public enum GameMessage {

    GAME_START("다리 건너기 게임을 시작합니다."),
    GAME_INPUT_LENGTH("다리의 길이를 입력해주세요."),
    GAME_INPUT_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GAME_INPUT_RESTART("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT_FIRST("최종 게임 결과"),
    GAME_RESULT_SECOND("게임 성공 여부: "),
    GAME_RESULT_THIRD("총 시도한 횟수: "),
    GAME_RESULT_SUCCESS("성공"),
    GAME_RESULT_FAIL("실패");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
