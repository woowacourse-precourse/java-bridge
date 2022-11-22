package bridge;

public enum Result {
    POSSIBLE(" O "),
    IMPOSSIBLE(" X "),
    BLANK("   "),
    DIV("|");

    private final String view;

    Result(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }
}
