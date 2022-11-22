package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    private enum Direction {
        UP(1, "U"),
        DOWN(0, "D");

        private  int num;
        private String word;
        Direction(int num, String word) {
            this.num = num;
            this.word = word;
        }
    }

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> answerBridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String moveDirection = checkUpOrDown();
            answerBridge.add(moveDirection);
        }
        return answerBridge;
    }

    private String checkUpOrDown() {
        int number;
        number = bridgeNumberGenerator.generate();
        if (number == Direction.UP.num) {
            return Direction.UP.word;
        }
        return Direction.DOWN.word;
    }
}
