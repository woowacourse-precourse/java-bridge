package bridge.domain;

import static bridge.constant.Moving.LOWER_SIDE;
import static bridge.constant.Moving.UPPER_SIDE;

import bridge.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;
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
        List<String> bridge = new ArrayList<>();
        IntStream.range(0, size).forEach(count -> {
            String moving = convertNumberToMoving(bridgeNumberGenerator.generate());
            bridge.add(moving);
        });
        System.out.println(bridge);
        return bridge;
    }

    private String convertNumberToMoving(int number) {
        if (number == 1) {
            return UPPER_SIDE;
        }
        return LOWER_SIDE;
    }
}
