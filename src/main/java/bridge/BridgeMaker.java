package bridge;

import bridge.View.ExceptionMessage;

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
     */
    public List<String> makeBridge(int size) {
        List<String> bridgeAnswer = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int moving = bridgeNumberGenerator.generate();
            String movingStatus = MovingStatus.findByMoving(moving).getMovingCommand();
            bridgeAnswer.add(movingStatus);
        }
        return bridgeAnswer;
    }

    public boolean validateBridgeSize(String inputSize) {
        try {
            validateIsNumeric(inputSize);
            validateIsRightRange(inputSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    void validateIsNumeric(String inputSize) throws IllegalArgumentException {
        if (!inputSize.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ExceptionMessage.NUMERIC_EXCEPTION_MESSAGE.getExceptionMessage());
        }
    }

    void validateIsRightRange(String inputSize) throws IllegalArgumentException {
        int bridgeSize = Integer.parseInt(inputSize);
        if (bridgeSize < 3 | bridgeSize > 20) {
            throw new IllegalArgumentException(ExceptionMessage.RANGE_EXCEPTION_MESSAGE.getExceptionMessage());
        }
    }
}
