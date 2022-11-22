package bridge.domain;

public enum PlayerStatus {
    PLAYING("진행 중"),
    FAIL("실패"),
    SUCCESS("성공");

    private final String name;
    private int tryCount;

    PlayerStatus(String name) {
        this.name = name;
        tryCount = 0;
    }

    public String getName() {
        return name;
    }

    public void addTryCount() {
        tryCount++;
    }

    public int getTryCount() {
        return tryCount;
    }
}
