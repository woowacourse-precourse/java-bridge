package bridge.config;

public enum GameResultStatus {
    O("O"), X("X");

    private String result;

    private GameResultStatus(String result) {
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }

}
