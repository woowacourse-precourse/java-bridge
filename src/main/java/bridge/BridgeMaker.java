package bridge;

import static bridge.model.UpOrDown.DOWN_SIGN;
import static bridge.model.UpOrDown.UP_SIGN;

import bridge.error.Error;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int UP_SIGNAL = 1;
    private static final int DOWN_SIGNAL = 0;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        if (size < 1) {
            throw new IllegalArgumentException(Error.SYSTEM_ERROR.getMessage());
        }

        return Stream.generate(bridgeNumberGenerator::generate)
                .map(this::convert)
                .limit(size)
                .collect(Collectors.toList());
    }

    private String convert(int number) {
        if (number != UP_SIGNAL && number != DOWN_SIGNAL) {
            throw new IllegalArgumentException(Error.SYSTEM_ERROR.getMessage());
        }
        if (number == UP_SIGNAL) {
            return UP_SIGN;
        }

        return DOWN_SIGN;
    }
}
