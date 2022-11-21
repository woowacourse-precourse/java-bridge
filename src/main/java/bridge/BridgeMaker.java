package bridge;

import static bridge.constant.Constant.MAX_BRIDGE_SIZE;
import static bridge.constant.Constant.MIN_BRIDGE_SIZE;
import static bridge.constant.ErrorMessage.BRIDGE_SIZE_IS_NOT_IN_RANGE;
import static bridge.constant.ErrorMessage.BRIDGE_SIZE_IS_NOT_NUMBER;

import bridge.view.InputView;
import bridge.view.OutputView;
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

    public int inputBridgeSize() {
        int bridgeSize;
        while (true) {
            OutputView.printRequestBridgeSize();
            String bridgeSizeInput = InputView.readBridgeSize();
            try {
                validateIsNumber(bridgeSizeInput);
                bridgeSize = Integer.parseInt(bridgeSizeInput);
                validateBridgeSize(bridgeSize);
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception);
                continue;
            }
            break;
        }
        return bridgeSize;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridgeNumbers = new ArrayList<>();
        while (bridgeNumbers.size() < size) {
            int randomValue = bridgeNumberGenerator.generate();
            bridgeNumbers.add(BridgeNumber.getMark(randomValue));
        }
        return bridgeNumbers;
    }

    private void validateIsNumber(String bridgeSize) {
        if (!bridgeSize.chars().allMatch(letter -> Character.isDigit((char) letter))) {
            throw new IllegalArgumentException(BRIDGE_SIZE_IS_NOT_NUMBER);
        }
    }

    private void validateBridgeSize(int bridgeSize) throws IllegalArgumentException {
        if (bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_IS_NOT_IN_RANGE);
        }
    }
}
