package bridge.util;

public enum UserInput {
    UP("U"), DOWN("D"), RETRY("R"), QUIT("Q");
    private String inputValue;
    UserInput(String inputValue) {
        this.inputValue = inputValue;
    }
    public String getInputValue() {
        return inputValue;
    }
}
