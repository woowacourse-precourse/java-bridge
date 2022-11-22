package bridge;

public class Validation {

    // 다리의 길이를 검증하는 기능
    public void validateBridgeSize(String enteredBridgeSize) {
        isDigit(enteredBridgeSize);
        int bridgeSize = Integer.parseInt(enteredBridgeSize);
        isInRange(bridgeSize);
    }

    // 입력받은 값이 숫자인지 검증하는 기능
    public void isDigit(String bridgeSize) {
        for (char c : bridgeSize.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
            }
        }
    }

    // 숫자가 맞다면 3~20사이의 숫자인지 검증하는 기능
    public void isInRange(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    // 플레이어가 이동할 칸을 검증하는 기능
    public void validateMoving(String enteredMoving) {
        if (!(enteredMoving.equals("U") || enteredMoving.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] U또는 D만 입력해 주세요");
        }
    }

    // 게임 재시작/종료 여부를 검증하는 기능
    public void validateGameCommand(String enteredGameCommand) {
        if (!(enteredGameCommand.equals("R") || enteredGameCommand.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] R또는 Q만 입력해 주세요");
        }
    }
}




