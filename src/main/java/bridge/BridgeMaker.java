package bridge;

import static bridge.util.Constants.BRIDGE_SIZE_REGEX;
import static bridge.util.Constants.MAX_BRIDGE_SIZE;
import static bridge.util.Constants.MIN_BRIDGE_SIZE;
import static bridge.util.ErrorMessage.ERROR_BRIDGE_SIZE_OVER_INT;
import static bridge.util.ErrorMessage.ERROR_BRIDGE_SIZE_RANGE;
import static bridge.util.ErrorMessage.ERROR_BRIDGE_SIZE_TYPE;

import bridge.model.Position;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
     */
    public List<String> makeBridge(int size) {
        return IntStream.generate(bridgeNumberGenerator::generate)
                .limit(size)
                .mapToObj(Position::findAbbreviationByNumber)
                .collect(Collectors.toList());
    }

    public static void validateBridgeSizeType(String input) {
        if (!BRIDGE_SIZE_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE_TYPE);
        }
    }

    public static int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException(ERROR_BRIDGE_SIZE_OVER_INT);
        }
    }

    public static void validateBridgeSizeRange(int size) {
        if (isLessThanRange(size) || isGreaterThanRange(size)) {
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE_RANGE);
        }
    }

    private static boolean isLessThanRange(int size) {
        return size < MIN_BRIDGE_SIZE;
    }

    private static boolean isGreaterThanRange(int size) {
        return size > MAX_BRIDGE_SIZE;
    }

}
