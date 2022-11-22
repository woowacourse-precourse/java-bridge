package bridge.enummodel;

public enum GameResultEnum {
    RESULT("성공", "실패"),
    CHECK("O","X");

    private final String win;
    private final String lose;

    GameResultEnum(String win, String lose) {
        this.win = win;
        this.lose = lose;
    }

    public String getValue(Boolean result) {
        if (result) return win;
        return lose;
    }

}
