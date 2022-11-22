package bridge;

public enum MODEnum {
    SUCCESS_GAME_MESSAGE("성공"),
    FAIL_GAME_MESSAGE("실패"),
    UP_GO("U"),
    DOWN_GO("D"),
    CAN_GO("O"),
    CAN_NOT_GO("X"),
    RE_GAME("R"),
    QUIT_GAME("Q");

    private String message;

    MODEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
