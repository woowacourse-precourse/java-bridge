package bridge;

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
        List<String> bridgeState = initialBridge();

        return null;
    }

    private List<String> initialBridge() {
        List<String> initialBridgeState = new ArrayList();
        initialBridgeState.add("[");
        initialBridgeState.add("[");
        return initialBridgeState;
    }

    private List<String> firstOAddBridge(List<String> preBridgeState, int randomNumber, int positionNumber) {
        if (randomNumber == 1 && positionNumber == 1) {
            preBridgeState.set(0, preBridgeState.get(0) + " O ");
            preBridgeState.set(1, preBridgeState.get(1) + "   ");
            return preBridgeState;
        }
        preBridgeState.set(0, preBridgeState.get(0) + "   ");
        preBridgeState.set(1, preBridgeState.get(1) + " O ");
        return preBridgeState;
    }

    private List<String> firstXAddBridge(List<String> preBridgeState, int randomNumber, int positionNumber) {
        if (randomNumber == 0 && positionNumber == 1) {
            preBridgeState.set(0, preBridgeState.get(0) + " X ");
            preBridgeState.set(1, preBridgeState.get(1) + "   ");
            return preBridgeState;
        }
        preBridgeState.set(0, preBridgeState.get(0) + "   ");
        preBridgeState.set(1, preBridgeState.get(1) + " X ");
        return preBridgeState;
    }

    private List<String> afterOAddBridge(List<String> preBridgeState, int randomNumber, int positionNumber) {
        if (randomNumber == 1 && positionNumber == 1) {
            preBridgeState.set(0, preBridgeState.get(0) + "| O ");
            preBridgeState.set(1, preBridgeState.get(1) + "|   ");
            return preBridgeState;
        }
        preBridgeState.set(0, preBridgeState.get(0) + "|   ");
        preBridgeState.set(1, preBridgeState.get(1) + "| O ");
        return preBridgeState;
    }

    private List<String> afterXAddBridge(List<String> preBridgeState, int randomNumber, int positionNumber) {
        if (randomNumber == 0 && positionNumber == 1) {
            preBridgeState.set(0, preBridgeState.get(0) + "| X ");
            preBridgeState.set(1, preBridgeState.get(1) + "|   ");
            return preBridgeState;
        }
        preBridgeState.set(0, preBridgeState.get(0) + "|   ");
        preBridgeState.set(1, preBridgeState.get(1) + "| X ");
        return preBridgeState;
    }
}
