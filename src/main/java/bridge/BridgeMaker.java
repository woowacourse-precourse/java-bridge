package bridge;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final Pattern INPUT_REGEX = Pattern.compile("^[0-9]*$");

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        System.out.println("다리 길이: " + size);
        return null;
    }

    public static void validateBridgeSizeType(String input) {
        if (!INPUT_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }

}
