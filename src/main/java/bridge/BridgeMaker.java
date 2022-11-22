package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final String NUMBER_ERROR_SENTENCE = "[ERROR] 임의의 숫자는 0 혹은 1이어야 합니다.";
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
        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            String board = changeRandomNumberToBoard(randomNumber);
            bridge.add(board);
        }
        return bridge;
    }

    private String changeRandomNumberToBoard(int randomNumber) {
        if (randomNumber == 0) {
            return "D";
        }
        if (randomNumber == 1) {
            return "U";
        }
        throw new IllegalArgumentException(NUMBER_ERROR_SENTENCE);
    }
}
