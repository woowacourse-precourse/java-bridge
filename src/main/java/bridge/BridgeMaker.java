package bridge;

import bridge.domain.Block;
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
        List<Integer> bridgeNumbers = getBridgeNumbers(size);
        List<String> bridgeCharacters = new ArrayList<>();
        for (Integer bridgeNumber : bridgeNumbers) {
            String bridgeCharacter = convertNumberToString(bridgeNumber);
            bridgeCharacters.add(bridgeCharacter);
        }
        return bridgeCharacters;
    }

    private List<Integer> getBridgeNumbers(int size) {
        List<Integer> bridgeNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            bridgeNumbers.add(bridgeNumber);
        }
        return bridgeNumbers;
    }

    private String convertNumberToString(int bridgeNumber) {
        if (bridgeNumber == Block.UP_BRIDGE.getNumber()) {
            return Block.UP_BRIDGE.getString();
        }
        return Block.DOWN_BRIDGE.getString();
    }

}
