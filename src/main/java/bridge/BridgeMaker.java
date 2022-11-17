package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static  int size; // InputView의 메서드 readBridgeSize를 활용해서 다리 사이즈를 받자

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     *
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 Frame [  |  |  ]
     */
    private List<String> makeBridgeFrame(int size) {
        return null;
    }
    // private List<String makeBridgeAblePosition()

    /** 최종 다리를 만든다고 생각하자. 이 메서드를 호출해서 쓴느 것이 아니라 다른 메서드에서 이 메서드를 호출해서 쓰자.
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> upAndDown = new ArrayList<>();
        int number = 0;
        for (int i = 0; i < size; i++) {
            number = bridgeNumberGenerator.generate();
            if (number == 1) {
                upAndDown.add("U");
            } else if (number == 0) {
                upAndDown.add("D");
            }
        }
        return upAndDown;
    }
}
