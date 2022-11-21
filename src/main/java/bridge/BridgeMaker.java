package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다. BridgeMaker의 필드(인스턴스 변수)를 변경할 수 없다. BridgeMaker의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수
 * 없다.
 */
public class BridgeMaker {

    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 20;
    public static final String ERROR_BRIDGE_SIZE = "[ERROR] 다리 길이는 3 이상 20 이하입니다.";
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public static boolean valueError = false;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        valueError = checkBridgeError(size);
        if (valueError) {
            return null;
        }
        for (int time = 0; time < size; time++) {
            String direction = toDirection(bridgeNumberGenerator.generate());
            bridge.add(direction);
        }
        return bridge;
    }

    private boolean checkBridgeError(int size) {
        try {
            checkRangeValidity(size);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    private void checkRangeValidity(int size) throws IllegalArgumentException {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            valueError = true;
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE);
        }
    }

    private String toDirection(int bridgeNumber) {
        if (bridgeNumber == 0) {
            return "D";
        }
        return "U";
    }
}
