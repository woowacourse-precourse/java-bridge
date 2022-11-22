package bridge.view;

public enum ConsoleMessage {
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_MOVING("이동할 칸을 입력해주세요. (위: U, 아래: D)"),
    INPUT_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT("최종 게임 결과"),
    GAME_SUCCESS("게임 성공 여부: 성공"),
    GAME_FAILURE("게임 성공 여부: 실패"),
    NUM_OF_TRIAL("총 시도한 횟수: ");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
