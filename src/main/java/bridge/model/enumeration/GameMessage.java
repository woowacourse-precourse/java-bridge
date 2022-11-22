package bridge.model.enumeration;

public enum GameMessage {

    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_MOVING_COMMAND("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RESTARTING_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    OUTPUT_INIT_GAME("다리 건너기 게임을 시작합니다."),
    OUTPUT_GAME_RESULT("최종 게임 결과"),
    OUTPUT_SUCCESS_OR_FAIL("게임 성공 여부 : "),
    OUTPUT_ATTEMPT_COUNT("총 시도한 횟수 : ");


    private final String gameMessage;

    GameMessage(String gameMessage) {
        this.gameMessage = gameMessage;
    }

    public String getGameMessage() {
        return gameMessage;
    }
}
