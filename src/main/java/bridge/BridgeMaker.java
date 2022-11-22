package bridge;

import bridge.config.ErrorMessageConstant;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * 각 칸이 무작위 방향을 가지는 다리 정보를 생성
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸은 "U", 아래 칸은 "D"로 표현된다.
     */
    public List<String> makeBridge(int size) throws IllegalArgumentException {
        validationNotNegative(size);
        return Stream.generate(() -> convertBridge(bridgeNumberGenerator.generate()))
                .limit(size)
                .collect(Collectors.toList());
    }

    private void validationNotNegative(int size) throws IllegalArgumentException {
        if (size < 0) {
            throw new IllegalArgumentException(ErrorMessageConstant.NUMBER_MUST_NOT_NEGATIVE);
        }
    }

    /**
     * 숫자로 반환된 다리 정보를 문자열로 변환
     * @param num 0 또는 1로 표현된 방향 정보
     * @return 0 -> "U", 1 -> "D" 반환
     * @throws IllegalArgumentException 0, 1 외의 다른 입력 발생 시 예외 처리
     */
    private static String convertBridge(int num) throws IllegalArgumentException {
        if (num == 0) {
            return "D";
        }
        if (num == 1) {
            return "U";
        }
        throw new IllegalArgumentException(ErrorMessageConstant.INVALID_BRIDGE_NUMBER);
    }
}
