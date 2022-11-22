package bridge.domain.bridge;

import static java.lang.Integer.parseInt;

import java.util.List;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

public class Bridge {

    private static final String REGEX = "^[0-9]+$";
    private static final int MIN_SIZE_OF_BRIDGE_LENGTH = 3;
    private static final int MAX_SIZE_OF_BRIDGE_LENGTH = 20;

    private static final String INPUT_NOT_INTEGER_ERROR = "[ERROR] 생성할 다리의 길이는 정수만 입력이 가능합니다.";
    private static final String INPUT_VALID_RANGE_OF_NUMBER_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    private final List<String> blocks;

    public Bridge(String input) {
        validateBridgeSize(input);
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.blocks = bridgeMaker.makeBridge(parseInt(input));
    }

    public int getSize() {
        return blocks.size();
    }

    public String getBlock(int index) {
        return blocks.get(index);
    }

    private void validateBridgeSize(String input) {
        validateInteger(input);
        validateRange(parseInt(input));
    }

    private void validateInteger(String size) {
        if (!size.matches(REGEX)) {
            throw new IllegalArgumentException(INPUT_NOT_INTEGER_ERROR);
        }
    }

    private void validateRange(int size) {
        if (size < MIN_SIZE_OF_BRIDGE_LENGTH || size > MAX_SIZE_OF_BRIDGE_LENGTH) {
            throw new IllegalArgumentException(INPUT_VALID_RANGE_OF_NUMBER_ERROR);
        }
    }
}
