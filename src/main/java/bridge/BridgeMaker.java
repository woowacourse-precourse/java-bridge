package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final int upperSide = 1;
    private final String up = "U";
    private final String down = "D";
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
        for (int i = 0; i < size; ++i) {
            int number = bridgeNumberGenerator.generate();
            bridge.add(chooseUpOrDownByNumber(number));
        }
        return bridge;
    }

    /**
     * 랜덤으로 생성된 값(0, 1)과 매칭되는 문자를 반환한다.
     * 0 : D, 1 : U
     * @param number
     * @return
     */
    private String chooseUpOrDownByNumber(int number) {
        if (number == upperSide) {
            return up;
        }
        return down;
    }
}
