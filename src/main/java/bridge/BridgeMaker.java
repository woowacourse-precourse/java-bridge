package bridge;

import bridge.util.Converter;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final String UP_BRIDGE_CHARACTER = "U";
    private static final String DOWN_BRIDGE_CHARACTER = "D";
    private static final int UP_BRIDGE_NUMBER = 1;
    private static final int DOWN_BRIDGE_NUMBER = 0;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        List<Integer> bridgeNumbers = makeBridgeNumbers(size);

        for (int bridgeNumber : bridgeNumbers){
            bridge.add(Converter.NumberToCharacter(bridgeNumber));
        }

        return bridge;
    }

    private List<Integer> makeBridgeNumbers(int size){
        List<Integer> bridgeNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++){
            int number = bridgeNumberGenerator.generate();
            bridgeNumbers.add(number);
        }

        return bridgeNumbers;
    }

    public static int getUpBridgeNumber() {
        return UP_BRIDGE_NUMBER;
    }

    public static int getDownBridgeNumber() {
        return DOWN_BRIDGE_NUMBER;
    }

    public static String getUpBridgeCharacter() {
        return UP_BRIDGE_CHARACTER;
    }

    public static String getDownBridgeCharacter() {
        return DOWN_BRIDGE_CHARACTER;
    }
}
