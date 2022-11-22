package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
     * @return 입력받은 길이만큼 0과 1 중 무작위 값을 생성한 리스트
     */
    private List<Integer> makeRandomNumberList(int size) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(bridgeNumberGenerator.generate());
        }
        return result;
    }

    /**
     * @param number 0 또는 1
     * @return 0은 "D"(아래 칸), 1은 "U"(위 칸)
     */
    private String randomNumberToDirection(int number) {
        if (number == 0) {
            return "D";
        }
        if (number == 1) {
            return "U";
        }
        return null;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        return makeRandomNumberList(size).stream()
                .map(this::randomNumberToDirection)
                .collect(Collectors.toList());
    }
}
