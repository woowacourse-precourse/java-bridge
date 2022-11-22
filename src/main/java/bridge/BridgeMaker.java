package bridge;

import bridge.domain.Moving;
import bridge.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static bridge.exception.ExceptionType.BRIDGE_SIZE_OUT_OF_RANGE;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    
    public final static int LOWER_BRIDGE_LENGTH = 3;
    public final static int UPPER_BRIDGE_LENGTH = 20;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        BridgeSizeValidator.validate(size);
        return IntStream.range(0, size)
                .mapToObj(v -> bridgeNumberConverter(bridgeNumberGenerator.generate()))
                .collect(Collectors.toList());
    }

    private String bridgeNumberConverter(int number) {
        if (number == 0) return Moving.DOWN.getDirection();
        if (number == 1) return Moving.UP.getDirection();
        throw new IllegalArgumentException();
    }

    enum BridgeSizeValidator {
        OUT_OF_RANGE((Integer size) -> {
            if (isBridgeSizeOutOfRange(size)) {
                throw new IllegalArgumentException(BRIDGE_SIZE_OUT_OF_RANGE.getMessage());
            }
        }),
        ;

        private final Validator<Integer> validator;

        BridgeSizeValidator(final Validator<Integer> validator) {
            this.validator = validator;
        }

        public static void validate(final Integer size) {
            Arrays.stream(values()).forEach(v -> v.validator.validate(size));
        }

        public static boolean isBridgeSizeOutOfRange(final int size) {
            return size < LOWER_BRIDGE_LENGTH || size > UPPER_BRIDGE_LENGTH;
        }
    }
}
