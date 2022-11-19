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
     * <p>
     *     다리 만들기, 다리 길이 체크, 건너는 방향 리스트에 저장
     * </p>
     */
    public List<String> makeBridge(int size) {
        checkRangeOfSize(size);
        List<String> moveCase = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            moveCase.add(addMoving());
        }
        return moveCase;
    }

    private void checkRangeOfSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private String addMoving() {
        final int num = bridgeNumberGenerator.generate();
        if (num == 0) {
            return "D";
        }
        return "U";
    }

}
