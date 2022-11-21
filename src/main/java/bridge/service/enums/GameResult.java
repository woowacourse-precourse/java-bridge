package bridge.service.enums;

public enum GameResult {
    SUCCESS("성공"),
    FAIL("실패");

    private String type;

    GameResult(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}