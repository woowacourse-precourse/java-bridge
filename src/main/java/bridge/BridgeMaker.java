package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final int DOWN_NUM = 0;
    private static final int UP_NUM = 1;
    private static final String DOWN_STRING = "D";
    private static final String UP_STRING = "U";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) throws IllegalStateException {
        if(!(this.bridgeNumberGenerator instanceof BridgeRandomNumberGenerator)) {
            bridgeNumberGeneratorException();
        }
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomNumToString(this.bridgeNumberGenerator.generate());
        }
        return bridge;
    }

    static String randomNumToString(int randomNum) throws IllegalStateException {
        if (isUpNum(randomNum)) {
            return UP_STRING;
        }
        if (isDownNum(randomNum)) {
            return DOWN_STRING;
        }
        bridgeNumberGeneratorException();
        return "";
    }

    private static boolean isUpNum(int num) {
        return num == UP_NUM;
    }

    private static boolean isDownNum(int num) {
        return num == DOWN_NUM;
    }

    private static void bridgeNumberGeneratorException() throws IllegalArgumentException {
        throw new IllegalStateException("[ERROR] Random Number가 제대로 생성되지 못했습니다.");
    }
}
