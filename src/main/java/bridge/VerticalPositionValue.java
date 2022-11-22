package bridge;

/**
 * 상하를 판단하는 열거 상수
 */
public enum VerticalPositionValue {
    DOWN(0, "D"),
    UP(1, "U");
    private final Integer number;
    private final String  sign;

    VerticalPositionValue(int number, String sign) {
        this.number = number;
        this.sign = sign;
    }

    public Integer getNumber() {
        return number;
    }

    public String getSign() {
        return sign;
    }
}
