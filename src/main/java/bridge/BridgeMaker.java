package bridge;

import bridge.constant.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final int MINIMUM_VALUE_OF_SIZE = 3;
    private final int MAXIMUM_VALUE_OF_SIZE = 20;
    private final int ANSWER_UP_BRIDGE_INT = 1;
    private final String ANSWER_UP_BRIDGE_STRING = "U";
    private final String ANSWER_DOWN_BRIDGE_STRING = "D";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        validate(size);
        return makeBridgeAnswers(size);
    }

    private void validate(int size) {
        if (MINIMUM_VALUE_OF_SIZE > size || size > MAXIMUM_VALUE_OF_SIZE) {
            ExceptionMessage.INPUT_WRONG_BRIDGE_LENGTH_MESSAGE.throwException();
        }
    }

    private List<String> makeBridgeAnswers(int size) {
        List<String> bridgeAnswers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            bridgeAnswers.add(generateAnswer());
        }

        return bridgeAnswers;
    }

    private String generateAnswer() {
        int answer = bridgeNumberGenerator.generate();

        if (answer == ANSWER_UP_BRIDGE_INT) {
            return ANSWER_UP_BRIDGE_STRING;
        }

        return ANSWER_DOWN_BRIDGE_STRING;
    }
}
