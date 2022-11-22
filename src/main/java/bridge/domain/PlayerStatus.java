package bridge.domain;

public enum PlayerStatus {
    PLAYING("진행 중"),
    FAIL("실패"),
    SUCCESS("성공");

    private final String name;
    private static int tryCount = 0;

    PlayerStatus(String name) {
        this.name = name;
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
