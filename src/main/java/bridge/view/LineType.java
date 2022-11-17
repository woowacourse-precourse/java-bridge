package bridge.view;

public enum LineType {
    UP("U","D"),
    DOWN("D","U");
    private String value1;
    private String value2;

    LineType(String value1,String value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getValue1() {
        return value1;
    }
    public String getValue2() {
        return value2;
    }
}
