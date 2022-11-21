package bridge;

public enum InputCase {
    UP("U"),
    DOWN("D"),
    RESTART("R"),
    QUIT("Q");

    InputCase(String input){
        this.input = input;
    }
    private final String input;

    public String getInput() {
        return input;
    }
}

