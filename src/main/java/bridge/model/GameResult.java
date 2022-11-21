package bridge.model;

public enum GameResult {
    WIN("성공"), LOSE("실패");

    private final String value;

    GameResult(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
