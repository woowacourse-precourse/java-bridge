package bridge;

import static bridge.model.Position.numberToPosition;
import static bridge.util.Constants.BRIDGE_SIZE_REGEX;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    // BridgeMaker의 필드(인스턴스 변수)를 변경할 수 없다.
    // BridgeMaker의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(numberToPosition(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    public static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("입력 범위를 초과하였습니다.");
        }
    }

    public static void validateBridgeSizeType(String input) {
        if (!BRIDGE_SIZE_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException("자연수만 입력해 주세요.");
        }
    }

    public static void validateBridgeSizeRange(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }


}
