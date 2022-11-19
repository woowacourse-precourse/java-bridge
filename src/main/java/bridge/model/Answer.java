package bridge.model;

public enum Answer {

    CORRECT("O"),
    INCORRECT("X"),
    NONE(" "),
    END("END");

    private final String output;

    Answer(String output){
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
