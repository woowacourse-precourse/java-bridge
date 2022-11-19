package bridge.bridge;

import bridge.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * 정해진 크기만큼 임의의 다리를 생성하는 기능입니다.
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(convertNumberToBridge(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    /**
     * 다리를 생성할 때 특정 칸에 대해 0 또는 1의 난수를 알맞은 알파벳에 매핑하는 메서드입니다.
     * @param randomNumber 생성된 0 또는 1입니다.
     * @return 각 경우에 맞는 알파벳 (U, D)입니다.
     */
    private String convertNumberToBridge(int randomNumber) {
        if (randomNumber == 0) return "U";
        return "D";
    }
}
