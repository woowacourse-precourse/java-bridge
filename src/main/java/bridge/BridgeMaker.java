package bridge;

import static bridge.constant.BridgeRule.MAXIMUM_SIZE;
import static bridge.constant.BridgeRule.MINIMUM_SIZE;
import static bridge.constant.BridgeRule.RANDOM_UPPER_INCLUSIVE;
import static bridge.constant.Moving.LOWER_SIDE;
import static bridge.constant.Moving.UPPER_SIDE;

import bridge.BridgeNumberGenerator;
import bridge.constant.ErrorMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        validate(size);
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

    private void validate(int size) {
        if (MINIMUM_SIZE <= size && size <= MAXIMUM_SIZE) {
            return;
        }
        throw new IllegalArgumentException(
                String.format(ErrorMessage.WRONG_BRIDGE_SIZE_FORMAT.getValue(), MINIMUM_SIZE, MAXIMUM_SIZE));
    }
}
