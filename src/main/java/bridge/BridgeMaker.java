package bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 *
 * 제공된 BridgeMaker 클래스를 활용해 구현해야 한다.
 * BridgeMaker의 필드(인스턴스 변수)를 변경할 수 없다.
 * BridgeMaker의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.
 */
public class BridgeMaker {

    public static final int START_INCLUSIVE_ZERO = 0;
    public static final int UP_VALUE = 1;
    public static final int DOWN_VALUE = 0;
    public static final String UP_MARK = "U";
    public static final String DOWN_MARK = "D";
    public static final String ERROR_INVALID_BRIDGE_NUMBER = "[ERROR] 다리의 숫자 값은 1 or 0만 가능합니다.";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        return IntStream.range(START_INCLUSIVE_ZERO, size)
                .mapToObj(i -> mapToString(bridgeNumberGenerator.generate()))
                .collect(Collectors.toList());
    }

    private String mapToString(int mark) {
        if (isUp(mark)) {
            return UP_MARK;
        }
        if (isDown(mark)) {
            return DOWN_MARK;
        }
        throw new IllegalArgumentException(ERROR_INVALID_BRIDGE_NUMBER);
    }

    private boolean isUp(int mark) {
        return mark == UP_VALUE;
    }

    private boolean isDown(int mark) {
        return mark == DOWN_VALUE;
    }
}
