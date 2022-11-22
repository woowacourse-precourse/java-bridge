package view;

public enum GameMessage {
    START_MESSAGE("다리 건너기 게임을 시작합니다."),
    SUCCESS_MESSAGE("게임 성공 여부: "),
    TRY_MESSAGE("총 시도한 횟수: ");

    private final String gameMessage;

    GameMessage(String gameMessage) {
        this.gameMessage = gameMessage;
    }

    public String getGameMessage() {
        return gameMessage;
    }

}
