package bridge.model.domains.constants;

/**
 * 게임 규칙으로 정해진 다리 칸 위치의 값을 저장하는 상수 클래스
 */
public enum Step {

    UP("U"),
    DOWN("D");

    private final String value;

    Step(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String convert(int bridgeNumber) {
        if (bridgeNumber == 1) {
            return UP.getValue();
        }
        if (bridgeNumber == 0) {
            return DOWN.getValue();
        }
        return null;
    }
}
