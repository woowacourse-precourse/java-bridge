package bridge.domain.bridge;

import bridge.resource.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

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
        validateSize(size);

        List<String> bridge = new ArrayList<>();

        while (size > 0) {
            assembleBlock(bridge);
            size--;
        }

        return bridge;
    }

    public List<String> makeBridge(String size) {
        validateNumeric(size);

        return makeBridge(Integer.parseInt(size));
    }

    private void validateNumeric(String size) {
        try {
            Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_OR_NUMBER_OUT_OF_RANGE_MESSAGE.getValue());
        }
    }

    private void validateSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(ErrorMessage.NOT_BETWEEN_3_AND_20_MESSAGE.getValue());
        }
    }

    private void assembleBlock(List<String> bridge) {
        BridgeBlock block = createBlock();
        bridge.add(block.direction);
    }

    private BridgeBlock createBlock() {
        int randomNumber = bridgeNumberGenerator.generate();

        for (BridgeBlock block : BridgeBlock.values()) {
            if (randomNumber == block.number) {
                return block;
            }
        }

        return BridgeBlock.UP;
    }
}
