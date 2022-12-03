package bridge;

import bridge.BridgeNumberGenerator;
import bridge.model.moving;

import java.util.ArrayList;
import java.util.List;

import static bridge.model.moving.*;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {


    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<Integer> bridge = new ArrayList<>();
        for (int idx = 0; idx < size; idx++) {
            bridge.add(bridgeNumberGenerator.generate());
            }

        return convertNumToMove(bridge);
    }

    public List<String> convertNumToMove(List<Integer> bridge) {
        List<String> convertedMove = new ArrayList<>();
        for (Integer number : bridge) {
            if (number.equals(down.getMovingNum())) {
                convertedMove.add(down.getUpDown());
            }
            if (number.equals(up.getMovingNum())) {
                convertedMove.add(up.getUpDown());
            }
        }
        return convertedMove;
    }







}
