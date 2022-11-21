package bridge.type;

public enum ErrorMessageDevType {

    BAD_BRIDGE_SIZE_MESSAGE("다리 크기가 유효하지 않습니다.: %d"),
    BAD_MAP_COMPONENT_MESSAGE("존재하지 않는 맵 구성요소가 포함되어 있습니다: %s");

    private final String message;

    ErrorMessageDevType(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
