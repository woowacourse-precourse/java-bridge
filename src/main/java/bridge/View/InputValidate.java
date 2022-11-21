package bridge.View;

public class InputValidate {

    public void IsCorrectFormatBridgeSize(String input) {
        if (!input.matches("-?\\d+(\\.\\d+)?")) {
            System.out.println("[Error] 다리 길이는 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void IsOverRangeBridgeSize(String input) {
        int length = Integer.parseInt(input);
        if ((length < 2)||(length > 20)) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void IsNoneInputBridgeSize(String input) {
        if (input.isBlank()) {
            System.out.println("[ERROR] 다리 길이를 입력해주셔야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
