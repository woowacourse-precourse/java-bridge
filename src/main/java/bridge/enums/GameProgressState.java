package bridge.enums;

public enum GameProgressState {
    RUNNING("실행 중"),
    STOP("중지"),
    GAME_CLEAR("게임 클리어");

    private String description;

    GameProgressState(String description) {
        this.description = description;
    }

}
