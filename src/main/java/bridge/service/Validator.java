package bridge.service;

public class Validator {
    private final int MIN_NUMBER = 3;
    private final int MAX_NUMBER = 20;
    private final String UP = "U";
    private final String DOWN = "D";

    public void validateBridgeSize(int input) {
        if(!(MIN_NUMBER <= input && input <= MAX_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
    public void validateDirection(String input) {
        if(!(input.equals(UP) || input.equals(DOWN))) {
            throw new IllegalArgumentException("[ERROR] 입력 문구는 U 혹은 D 여야 합니다.");
        }
    }
}
