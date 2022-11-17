package bridge.generator;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final static int UP = 1;
    private final static int DOWN = 0;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {

    }

    public List<String> convertNumberToUpAndDown(List<Integer> numbers) {
        List<String> result = new ArrayList<>();

        for(int number : numbers) {
            if(number == UP) {
                result.add("U");
            }
            if(number == DOWN) {
                result.add("D");
            }
        }

        return result;
    }

    public List<Integer> generateNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            numbers.add(bridgeNumberGenerator.generate());
        }

        return numbers;
    }
}
