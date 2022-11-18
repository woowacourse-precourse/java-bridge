package bridge.view;

public enum MessageView {

    PLAY_BRIDGE_GAME("다리 건너기 게임을 시작합니다." + "\n"),
    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    SELECT_TO_MOVE("\n" + "이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY_OR_NOT_GAME("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_GAME_RESULT("최종 게임 결과"),
    WHETHER_GAME_SUCCESS("\n" + "게임 성공 여부: "),
    TOTAL_ATTEMPTS("총 시도한 횟수: ");

    private final String message;

    MessageView(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}