package bridge.config;

public enum GameStatus {
    SUCCESS("성공"), FAIL("실패");

    private String value;

    private GameStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
