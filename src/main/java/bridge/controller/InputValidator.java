package bridge.controller;

public class InputValidator {
    public int validatePureNumber(String input){
        try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자만 입력 가능합니다.");
        }
    }

    public void validateBridgeSizeRange(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public String validateMoving(String input) {
        if (input.equals("U") || input.equals("D")) {
            return input;
        }
        throw new IllegalArgumentException("[ERROR] 이동할 칸 입력은 대문자 U또는 대문자 D만 가능합니다.");
    }

    public String validateRestart(String input) {
        if (input.equals("R") || input.equals("Q")) {
            return input;
        }
        throw new IllegalArgumentException("[ERROR] 재시작 여부 입력은 대문자 R또는 대문자 Q만 가능합니다.");
    }
}
