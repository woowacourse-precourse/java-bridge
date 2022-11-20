package bridge.exception;

public class BridgeGameInputException {

    public void validateBridgeSize(String size) {
        validateBridgeSizeBlank(size);
        validateBridgeSizeNumber(size);
        validateBridgeSizeRange(size);
    }

    private void validateBridgeSizeNumber(String size) {
        if (!size.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 숫자만 입력가능합니다.");
        }
    }

    private void validateBridgeSizeRange(String size) {
        int bridgeSize = Integer.parseInt(size);
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3에서 20사이입니다.");
        }
    }

    private void validateBridgeSizeBlank(String size) {
        if (size.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이를 입력해주세요.");
        }
    }

    public void validateMovingChoice(String move) {
        if (!(move.equals("U") || move.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U또는 D만 입력가능합니다.");
        }
    }

    public void validateGameCommand(String gameCommand) {
        if (!(gameCommand.equals("R") || gameCommand.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] 게임 재시작여부는 R또는 Q만 입력가능합니다.");
        }
    }

}

