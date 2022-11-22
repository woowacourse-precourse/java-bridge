package bridge;

import bridge.constant.Movement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static bridge.constant.Movement.DOWN;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final List<String> bridges = new ArrayList<>();

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        IntStream.range(0, size).forEach((__) -> {
            int generateNumber = bridgeNumberGenerator.generate();
            isUpSide(generateNumber);
            isDownSide(generateNumber);
        });
        System.out.println(bridges);
        return bridges;
    }

    private void isDownSide(int generateNumber) {
        if (generateNumber == DOWN.getUpAndDown()) {
            bridges.add(DOWN.getUpAndDownMovement());
        }
    }

    private void isUpSide(int generateNumber) {
        if (generateNumber == Movement.UP.getUpAndDown()) {
            bridges.add(Movement.UP.getUpAndDownMovement());
        }
    }
}
