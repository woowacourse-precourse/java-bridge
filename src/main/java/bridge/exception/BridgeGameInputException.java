package bridge.exception;

public class BridgeGameInputException {

    public void validateBridgeSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3에서 20사이입니다.");
        }
    }

    public void validateMovingChoice(String move) {
        if (!(move.equals("U") || move.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U또는 D만 입력가능합니다.");
        }
    }
}

