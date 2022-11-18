package bridge.model;

public enum Restart {

    TRUE("R"),
    FALSE("Q");

    private final String input;

    Restart(String input){
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
