package bridge;

import static bridge.Expression.DOWN;
import static bridge.Expression.UP;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        List<String> bridge = IntStream.generate(bridgeNumberGenerator::generate)
                .limit(size)
                .mapToObj(this::expressionByNumber)
                .collect(Collectors.toList());

        return bridge;

    }

    private String expressionByNumber(int bridgeNumber) {
        String expression = "";
        if (bridgeNumber == 0) {
            expression = DOWN.expressThat();
        }
        if (bridgeNumber == 1) {
            expression = UP.expressThat();
        }

        return expression;
    }

}
