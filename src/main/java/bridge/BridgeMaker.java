package bridge;

import response.ErrorResponse;
import response.UserInputException;

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
//        validateBridgeSize(size);
        List<Integer> integerBridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int generatedRandomNumber = this.bridgeNumberGenerator.generate();
            integerBridge.add(generatedRandomNumber);
        }
        List<String> stringBridge = convertIntegerBridgeIntoStringBridge(integerBridge);

        return stringBridge;
    }

    private void validateBridgeSize(int size) {
        if (size < 3 || size > 20) {
            throw new UserInputException(ErrorResponse.INPUT_BRIDE_SIZE_RANGE_ERROR);
        }
    }

    private List<String> convertIntegerBridgeIntoStringBridge(List<Integer> integerBridge) {
        List<String> stringBridge = new ArrayList<>();
        for (Integer integer : integerBridge) {
            if (integer.equals(0)) {
                stringBridge.add("D");
                continue;
            }
            stringBridge.add("U");
        }

        return stringBridge;
    }
}
