package bridge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public static List<String> bridge = new ArrayList<>();

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }


    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        int randNum;
        for (int i = 0; i < size; i++) {
            randNum = bridgeNumberGenerator.generate();
            if (randNum == 1) {
                bridge.add("U");
            }
            if (randNum == 0) {
                bridge.add("D");
            }
        }
        return bridge;
    }

    public static List<String> getBridge() {
        return bridge;
    }

    public List<String> getRandomBridge(int size) {
        bridge = new ArrayList<>();
        makeBridge(size);
        return bridge;
    }

}

/**
 * 제공된 BridgeMaker 클래스를 활용해 구현해야 한다. BridgeMaker 의 필드(인스턴스 변수)를 변경할 수 없다. BridgeMaker 의 메서드의 시그니처(인자, 이름)와 반환타입은 변경할 수
 * 없다.
 */