package bridge.config;

public enum GameResultStatus {
    O("O", -1), X("X", 1);

    private String result;
    private int value;

    private GameResultStatus(String result, int value) {
        this.result = result;
        this.value = value;
    }

    public String getResult() {
        return this.result;
    }

}
