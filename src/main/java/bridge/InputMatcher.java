package bridge;

public enum InputMatcher {

    UPSIDE_OF_BRIDGE("U"),
    DOWNSIDE_OF_BRIDGE("D");

    String sideOfBridge;

    InputMatcher(String sideOfBridge) {
        this.sideOfBridge = sideOfBridge;
    }

    public boolean isCorrect(String s) {
        return sideOfBridge.equals(s);
    }


}
