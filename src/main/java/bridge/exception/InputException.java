package bridge.exception;

public class InputException {
    public void validateBridgeSize(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력했습니다.");
        }
        if (Integer.parseInt(bridgeSize) < 3 || Integer.parseInt(bridgeSize) > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public void validateMoving(String moving) {
        if (!moving.equals("U") && !moving.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 주어진 선택지를 벗어났습니다.");
        }
    }

    public void validateGameCommand(String gameCommand) {
        if (!gameCommand.equals("R") && !gameCommand.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 주어진 선택지를 벗어났습니다.");
        }
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
