package bridge;

public class InputValidation {

    public void checkBlank(String input) throws IllegalArgumentException {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }

    public void checkNumeric(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요.");
        }
    }

    public void checkBridgeSize(int bridgeSize) throws IllegalArgumentException {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3 이상 20 이하여야 합니다.");
        }
    }

    public void checkMoving(String input) throws IllegalArgumentException {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException("[ERROR] U 또는 D만 입력 가능합니다.");
        }
    }

    public void checkGameCommand(String input) throws IllegalArgumentException {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q만 입력 가능합니다.");
        }
    }

}
