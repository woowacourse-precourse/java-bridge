package bridge;

import bridge.constance.GameConstance;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final int UP_BLOCK = 1;
    private static final int DOWN_BLOCK = 0;
    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final Map<Integer, String> crossableBlocks = Map.of(
            UP_BLOCK, GameConstance.UP_BLOCK_EXPRESSION,
            DOWN_BLOCK, GameConstance.DOWN_BLOCK_EXPRESSION
    );

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        return IntStream.rangeClosed(1, size)
                .mapToObj(action -> {
                    int randomNumber = createRandomNumber();
                    return createBlockByNumber(randomNumber);
                })
                .collect(Collectors.toList());
    }

    private int createRandomNumber() {
        return bridgeNumberGenerator.generate();
    }

    private String createBlockByNumber(int number) {
        return crossableBlocks.get(number);
    }
}
