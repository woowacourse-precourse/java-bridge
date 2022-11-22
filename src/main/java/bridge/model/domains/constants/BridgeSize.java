package bridge.model.domains.constants;

/**
 * 정해진 다리 길이 제한을 저장하는 상수 클래스
 */
public enum BridgeSize {

    MINIMUM(3),
    MAXIMUM(20);

    private final int value;

    BridgeSize(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
