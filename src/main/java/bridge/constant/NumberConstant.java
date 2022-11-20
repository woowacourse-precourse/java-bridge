package bridge.constant;

public enum NumberConstant {
    MINIMUM_BRIDGE_SIZE(1),
    MAXIMUM_BRIDGE_SIZE(20),
    FIRST_ROW(0),
    SECOND_ROW(1);

    final Integer code;

    NumberConstant(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
