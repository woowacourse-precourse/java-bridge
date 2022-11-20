package bridge.game;

public enum Result {
    FAIL(" X ", "실패"),
    SUCCESS(" O ", "성공"),
    CONTINUE("   ", "계속"),
    NONE("   ", "해당없음");

    private final String print;
    private final String korean;

    Result(String print, String korean) {
        this.print = print;
        this.korean = korean;
    }

    public String getKorean() {
        return korean;
    }

    @Override
    public String toString() {
        return print;
    }
}
