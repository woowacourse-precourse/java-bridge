package bridge;

public class Validator {

    public Validator() {
    }

    public void validateBridgeSize(String inputValue) {
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(inputValue);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public void validateMoving(String inputValue) {
        if (!inputValue.equals("U") && !inputValue.equals("D")) {
            throw new IllegalArgumentException("[ERROR] \"U\" 또는 \"D\" 만 입력할 수 있습니다.");
        }
    }

    public void validateGameCommand(String inputValue) {
        if (!inputValue.equals("R") && !inputValue.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] \"R\" 또는 \"Q\" 만 입력할 수 있습니다.");
        }
    }
}
