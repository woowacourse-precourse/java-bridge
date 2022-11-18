package bridge.constant;

public enum NumberConstant {
    MINIMUM_BRIDGE_SIZE(1),
    MAXIMUM_BRIDGE_SIZE(20);

    final Integer code;

    NumberConstant(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
