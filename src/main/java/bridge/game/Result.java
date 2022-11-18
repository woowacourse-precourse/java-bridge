package bridge.game;

public enum Result {
    FAIL(" X ", "실패", 0),
    SUCCESS(" O ", "성공", 1),
    CONTINUE("   ", "계속", 2),
    NONE("   ", "해당없음", 3);

    private final String print;
    private final String korean;
    private final int status;

    Result(String print, String korean, int status) {
        this.print = print;
        this.korean = korean;
        this.status = status;
    }

    public String getKorean() {
        return korean;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return print;
    }
}
