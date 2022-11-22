package bridge.constant.enumtype;

public enum BridgeLengthInclusive {
    START(3), END(20);

    private Integer value;

    BridgeLengthInclusive(Integer value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }

    public Integer getValue() {
        return value;
    }
}
