package bridge.validation;

import bridge.enums.MovingDirection;

public class InputValidatorImpl implements InputValidator{

    public void validateBridgeSize(String input) {
        final int MIN_BRIDGE_SIZE = 3;
        final int MAX_BRIDGE_SIZE = 20;
        final String form = "[-+]?\\d*\\.?\\d+";

        if(input.matches(form)==false) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }

        if(Integer.parseInt(input)<MIN_BRIDGE_SIZE || Integer.parseInt(input)>MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(String.format("[ERROR] 다리 길이는 %d부터 %d 사이의 숫자여야 합니다.",
                    MIN_BRIDGE_SIZE, MAX_BRIDGE_SIZE));
        }
    }

    public void validateMoving(String moving) {
        if((moving.equals(MovingDirection.LOWER.getDirection()) ||
                moving.equals(MovingDirection.UPPER.getDirection()))==false) {

            throw new IllegalArgumentException(String.format("[ERROR] 위 : %s, 아래: %s 중 입력해야 합니다.",
                  MovingDirection.LOWER.getDirection(), MovingDirection.UPPER.getDirection()));
        }
    }
}
