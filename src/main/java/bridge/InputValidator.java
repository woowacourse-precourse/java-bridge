package bridge;

public class InputValidator {
    private final String invalidNumberMessage = "잘못된 입력입니다. 다시 입력해주세요.";
    private final String invalidBridgeSizeMessage = "다리의 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final String invalidMoveDirectionMessage = "이동할 방향은 U 또는 D여야 합니다.";
    private final String invalidGameCommandMessage = "게임 재시도 여부는 R 또는 Q를 입력해야 합니다.";


    /* 입력받은 문자열이 숫자인지 그리고 3이상 20이하인지 확인한다. */
    public void validateBridgeSize(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException(invalidNumberMessage);
        }
        int bridgeSize = Integer.parseInt(input);
        if (!isValidBridgeSize(bridgeSize)) {
            throw new IllegalArgumentException(invalidBridgeSizeMessage);
        }
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidBridgeSize(int bridgeSize) {
        return bridgeSize >= 3 && bridgeSize <= 20;
    }

    public void validateMoveDirection(String input) {
        if (!isMoveDirection(input)) {
            throw new IllegalArgumentException(invalidMoveDirectionMessage);
        }
    }

    private boolean isMoveDirection(String input) {
        return "U".equals(input) || "D".equals(input);
    }

    public void validateGameCommand(String input) {
        if (!isGameCommand(input)) {
            throw new IllegalArgumentException(invalidGameCommandMessage);
        }
    }

    private boolean isGameCommand(String input) {
        return "R".equals(input) || "Q".equals(input);
    }
}
