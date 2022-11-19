package bridge.constant;

public enum Command {
    RETRY("R"),
    QUIT("Q");

    private String shortCut;

    Command(String shortCut) {
        this.shortCut = shortCut;
    }

    public String shortCut() {
        return this.shortCut;
    }
}
