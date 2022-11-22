package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.enumeration.ErrorMessage;
import bridge.enumeration.GameCommand;
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
        List<String> blocks = new ArrayList<>();
        checkRange(size);
        for (int i = 0; i < size; i++) {
            String block = convert(bridgeNumberGenerator.generate());
            blocks.add(block);
        }
        return blocks;
    }

    private void checkRange(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            System.out.println(ErrorMessage.BRIDGE_OUT_OF_RANGE.getErrorMessage());
            throw new IllegalStateException(ErrorMessage.BRIDGE_OUT_OF_RANGE.getErrorMessage());
        }
    }

    private String convert(int number) {
        if (number == 1) {
            return GameCommand.UP.getCommand();
        }
        return GameCommand.DOWN.getCommand();
    }
}
