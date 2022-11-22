package bridge;

import static bridge.constant.BridgeRule.RANDOM_UPPER_INCLUSIVE;
import static bridge.constant.Moving.LOWER_SIDE;
import static bridge.constant.Moving.UPPER_SIDE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        IntStream.range(0, size).forEach(count -> {
            String moving = convertNumberToMoving(bridgeNumberGenerator.generate());
            bridge.add(moving);
        });
        return bridge;
    }

    private String convertNumberToMoving(int number) {
        if (number == RANDOM_UPPER_INCLUSIVE) {
            return UPPER_SIDE;
        }
        return LOWER_SIDE;
    }


}
