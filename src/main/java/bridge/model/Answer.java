package bridge.model;

public enum Answer {

    CORRECT("O"),
    INCORRECT("X"),
    NONE(" ");

    private String output;

    Answer(String output){
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
