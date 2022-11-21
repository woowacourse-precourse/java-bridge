package bridge.domain;

public enum PlayerStatus {
    PLAYING("진행 중"),
    FAIL("실패"),
    SUCCESS("성공");

    private final String name;

    PlayerStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
