package bridge.validation;

import bridge.enums.MovingDirection;

public interface InputValidator {
    /**
     * 입력받은 다리의 길이를 검증한다.
     */
    void validateBridgeSize(String input);
    void validateMoving(String moving);
}
