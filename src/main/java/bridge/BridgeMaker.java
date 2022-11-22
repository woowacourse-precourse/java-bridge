package bridge;

import bridge.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int FIRST_BLOCK = 0;
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validate(size);
        List<String> bridge = new ArrayList<>();

        for (int block = FIRST_BLOCK; block < size; block++) {
            int generatedNumber = bridgeNumberGenerator.generate();
            bridge.add(generateBlock(generatedNumber));
        }
        return bridge;
    }

    private void validate(int size) {
        if (isInvalidRange(size)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_SIZE_RANGE);
        }
    }

    private static boolean isInvalidRange(int size) {
        return size < MIN_SIZE || size > MAX_SIZE;
    }

    private String generateBlock(int generatedNumber) {
        if (isDownCommand(generatedNumber)) {
            return Moving.DOWN.getDirection();
        }
        return Moving.UP.getDirection();
    }

    private boolean isDownCommand(int generatedNumber) {
        return Moving.DOWN.isSameCommand(generatedNumber);
    }
}
