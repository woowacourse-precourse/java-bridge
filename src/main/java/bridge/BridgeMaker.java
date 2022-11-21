package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int BRIDGE_MAX_SIZE = 20;
    private static final String UP_BRIDGE_LETTER = "U";
    private static final String DOWN_BRIDGE_LETTER = "D";
    private static final int UP_BRIDGE_NUMBER = 1;
    private static final int DOWN_BRIDGE_NUMBER = 0;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public static int getBridgeMinSize() {
        return BRIDGE_MIN_SIZE;
    }

    public static int getBridgeMaxSize() {
        return BRIDGE_MAX_SIZE;
    }

    public static String getUpBridgeLetter() {
        return UP_BRIDGE_LETTER;
    }

    public static String getDownBridgeLetter() {
        return DOWN_BRIDGE_LETTER;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<Integer> bridgeNumbers = makeBridgeNumbers(size);
        List<String> bridgeLetters = new ArrayList<>();
        for (Integer bridgeNumber : bridgeNumbers) {
            String bridgeCharacter = convertNumberToLetter(bridgeNumber);
            bridgeLetters.add(bridgeCharacter);
        }
        return bridgeLetters;
    }

    private List<Integer> makeBridgeNumbers(int size) {
        List<Integer> bridgeNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            bridgeNumbers.add(bridgeNumber);
        }
        return bridgeNumbers;
    }

    private String convertNumberToLetter(int bridgeNumber) {
        if (bridgeNumber == UP_BRIDGE_NUMBER) {
            return UP_BRIDGE_LETTER;
        }
        return DOWN_BRIDGE_LETTER;
    }

}
