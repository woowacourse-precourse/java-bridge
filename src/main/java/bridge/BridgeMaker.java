package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final String UP_COMMAND = "U";
    private static final String DOWN_COMMAND = "D";
    private static final int REPEAT_START = 0;

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
        List<String> command = new ArrayList<>(Arrays.asList(DOWN_COMMAND, UP_COMMAND));

        IntStream.range(REPEAT_START, size)
                .forEach(repeat -> bridge.add(command.get(bridgeNumberGenerator.generate())));

        return bridge;
    }
}
