package bridge.domain;

public enum CorrectResult {
    CORRECT("O"),
    INCORRECT("X");

    private final String result;

    CorrectResult(String result) {
        this.result = result;
    }

    public String getResult(boolean correct) {
        if(correct) {
            return CORRECT.result;
        }
        return INCORRECT.result;
    }
}
