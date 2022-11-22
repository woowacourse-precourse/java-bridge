package bridge.game;

public enum Result {
    SUCCESS("성공"),
    FAIL("실패"),
    ;

    private final String label;

    Result(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
