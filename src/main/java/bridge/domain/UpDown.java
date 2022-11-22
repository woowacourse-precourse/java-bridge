package bridge.domain;

public enum UpDown {
    UP(1, "U"),
    DOWN(0, "D");

    private int number;
    private String result;

    UpDown(int number, String direction) {
        this.number = number;
        this.result = direction;
    }

    public int getNumber() {
        return number;
    }

    public String getResult() {
        return result;
    }
}
