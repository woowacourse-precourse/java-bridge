package bridge.view;

public enum LineType {
    UP("U","D","O"),
    DOWN("D","U","O"),
    UP_FAIL("D","U","X"),
    DOWN_FAIL("U","D","X");

    private String value1;
    private String value2;
    private String value3;

    LineType(String value1, String value2, String value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public String getValue1() {
        return value1;
    }
    public String getValue2() {
        return value2;
    }
    public String getValue3() {
        return value3;
    }
}
