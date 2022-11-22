package bridge.view.constants;

/**
 * 이동 현황 지도의 형식에 사용되는 기호를 저장하는 상수 클래스
 */
public enum MovingMapFormat {

    PREFIX("[ "),
    DELIMITER(" | "),
    SUFFIX(" ]");

    private final String value;

    MovingMapFormat(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
