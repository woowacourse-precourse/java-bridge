package bridge.View;

public enum GameMessage {
    GAME_SUCCESS_STATUS("\n게임 성공 여부: "),
    GAME_SUCCESS("성공"),
    GAME_FAILURE("실패"),
    GAME_START_MESSAGE("다리 건너기 게임을 시작합니다."),
    GAME_MAP_MESSAGE("\n최종 게임 결과"),
    GAME_TRY_COUNT("총 시도한 횟수: ");

    private final String gameMessage;
    GameMessage(String gameMessage){
        this.gameMessage = gameMessage;
    }

    public String getGameMessage(){
        return gameMessage;
    }

}
