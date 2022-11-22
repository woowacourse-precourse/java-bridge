package bridge.valid;

public class InputValid {
    public boolean checkLengthValid(String test) {
        isNumber(test);
        return true;
    }

    public boolean checkChoice(String test) {

        return true;
    }

    private void isNumber(String test) {
        if (test.matches("[+-]?\\d*(\\.\\d+)?") == false) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 하나의 숫자여야 합니다.");
        }
    }
}
