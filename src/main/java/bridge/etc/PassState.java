package bridge.etc;

public enum PassState {
    RIGHT("O"),
    FAIL("X"),
    NO_CHOICE(" ");

    private String stateString;

    PassState(String stateString) {
        this.stateString = stateString;
    }

    @Override
    public String toString() {
        return stateString;
    }
}
