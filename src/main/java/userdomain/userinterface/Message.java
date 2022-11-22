package userdomain.userinterface;

public enum Message {

    START_GAME("다리 건너기 게임을 시작합니다."),
    BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    BRIDGE_MOVING("다리의 길이를 입력해주세요."),
    SELECT_MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RE_START("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q"),
    GAME_RESULT("최종 게임 결과"),
    GAME_SUCCESS("게임 성공 여부:"),
    TOTAL_TRY("총 시도한 횟수: "),
    SUCCESS("성공"),
    FAIL("실패"),
    BRIDGE_SIZE_RANGE_ERROR("[ERROR] 다리의 길이가 범위를 초과합니다 3이상 20 이하의 범위여야 합니다"),
    BRIDGE_SIZE_INPUT_ERROR("[ERROR] 다리 길이의 입력은 숫자만 가능합니다"),
    BRIDGE_SIZE_INPUT_ZERO_ERROR("[ERROR] 다리 길이의 첫 입력은 0이 될수 없습니다"),
    USER_MOVE_INPUT_ERROR("[ERROR] 사용자가 이동할 칸의 입력은 U,D만 입력 가능합니다"),
    USER_MOVE_INPUT_SIZE_ERROR("[ERROR] 사용자가 이동할 칸의 입력은 한번에 하나만 입력 가능합니다"),
    USER_RETRY_INPUT_RANGE_ERROR("[ERROR] 재시작 여부의 입력은 R,Q만 입력 가능합니다"),
    USER_RETRY_INPUT_SIZE_ERROR("[ERROR] 재시작 여부의 입력은 하나만 입력 가능합니다");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
