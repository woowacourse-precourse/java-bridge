package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int MIN_RANGE = 3;
    private static final int MAX_RANGE = 20;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     * 즉, 랜덤 인풋에서 1이면 U, 0이면 D로 표현한다.
     */
    public List<String> makeBridge(int size) throws IllegalArgumentException {
        List<String> bridge = new ArrayList<>();
        int number;

        validate(size);
        for (int i = 0; i < size; i++) {
            number = generateZeroOrOne();
            bridge.add(parseZeroOrOneToUorD(number));
        }

        return bridge;
    }

    private void validate(int number) throws IllegalArgumentException {
        if (number < MIN_RANGE || MAX_RANGE < number) {
            throw new IllegalArgumentException("[ERROR] 다리길이는 3이상 20이하 입니다.");
        }
    }

    private int generateZeroOrOne() {
        return bridgeNumberGenerator.generate();
    }

    private String parseZeroOrOneToUorD(int number) {
        String movement = "";
        for (BridgeStatus bridgeStatus : BridgeStatus.values()) {
            if (number == bridgeStatus.getNumber()) {
                movement = bridgeStatus.getMovement();
            }
        }
        return movement;
    }
}