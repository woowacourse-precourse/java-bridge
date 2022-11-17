package bridge.domain;


import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator; // 변경이 불가능한 기본 인스턴스 변수

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            if (bridgeNumber == 1) {
                bridge.add("U");
            }
            if (bridgeNumber == 0) {
                bridge.add("D");
            }
        }
        return bridge;
    }

    /**
     * 다리 건너기 게임을 관리하는 클래스
     */
    public static class BridgeGame {
        /**
         * 사용자가 칸을 이동할 때 사용하는 메서드
         * <p>
         * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
         */
        public void move() {
        }

        /**
         * 사용자가 게임을 다시 시도할 때 사용하는 메서드
         * <p>
         * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
         */
        public void retry() {
        }
    }
}
