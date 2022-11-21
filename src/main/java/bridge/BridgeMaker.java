package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 *
 * 참고
 * 인스턴스 변수 변경X
 * 메서드 시그니처(인자, 이름), 반환 타입 변경X
 */
public class BridgeMaker {
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final int UP_NUMBER = 1;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<Integer> bridges = new ArrayList<>();

        fillBridgeNumber(size, bridges);

        return bridges.stream()
                .map(number -> Direction.findByDirectionNumber(number))
                .collect(Collectors.toList());
    }

    private void fillBridgeNumber(int size, List<Integer> bridges) {
        for (int index = 0; index < size; index++) {
            int number = bridgeNumberGenerator.generate();
            bridges.add(number);
        }
    }
}
