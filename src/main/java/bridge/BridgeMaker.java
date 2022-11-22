package bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static bridge.Message.INVALID_BRIDGE_SIZE;
import static bridge.Message.INVALID_RANDOM_NUMBER;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateSize(size);

        return Stream.generate(bridgeNumberGenerator::generate)
                .limit(size)
                .map(this::numberToString)
                .collect(Collectors.toList());
    }


    private void validateSize(int size) {

        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE);
        }
    }

    private void validateNumber(int number) {
        if (number != 1 && number != 0) {
            throw new IllegalStateException(INVALID_RANDOM_NUMBER);
        }
    }

    private String numberToString(int number) {
        validateNumber(number);

        if (number == 1) {
            return "U";
        }

        return "D";
    }
}
