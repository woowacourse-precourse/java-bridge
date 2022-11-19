package bridge.validation;

public class Validation {
    public void validateBridgeSize(String bridgeSize) {
        try {
            int size = Integer.parseInt(bridgeSize);
            if ((size < 3) || (size > 20)) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public void validateMoving(String moving) {
        if (moving.equals("U") || moving.equals("D")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] U 또는 D만 입력 가능합니다.");
    }

    public void validateGameCommand(String gameCommand) {
        if (gameCommand.equals("R") || gameCommand.equals("Q")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] R 또는 Q만 입력 가능합니다.");
    }
}
