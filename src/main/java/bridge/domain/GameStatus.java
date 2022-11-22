package bridge.domain;

public enum GameStatus {
    SUCCESS("성공"), FAIL("실패");

    private final String name;

    GameStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
