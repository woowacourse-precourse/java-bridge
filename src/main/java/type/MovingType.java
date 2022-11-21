package type;

public enum MovingType {
    MOVE("O"),
    NOT_MOVE("X"),
    BLANK(" ");

    private String result;

    MovingType(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
