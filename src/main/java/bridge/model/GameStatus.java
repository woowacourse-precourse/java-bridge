package bridge.model;

public enum GameStatus {
    PLAYING, COMPLETE, FAIL, FAIL_QUIT;

    public boolean complete() {
        return this == COMPLETE;
    }

    public boolean end() {
        return this == FAIL;
    }

    public boolean quit() {
        return this == COMPLETE || this == FAIL_QUIT;
    }
}
