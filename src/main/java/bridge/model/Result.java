package bridge.model;

public enum Result {

    SUCCESS("성공"),
    FAILED("실패");

    private final String output;

    Result(String output){
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
