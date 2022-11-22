package bridge;

public class Validator {
    public static final int MINIMUM_BRIDGE_LENGTH = 3;
    public static final int MAXIMUM_BRIDGE_LENGTH = 20;


    public boolean inInRange(int input) {
        return input >= MINIMUM_BRIDGE_LENGTH && input <= MAXIMUM_BRIDGE_LENGTH;
    }

    public boolean bridgeSizeValidator(String input) {
        try {
            int bridgeSize = Integer.parseInt(input);
            if (inInRange(bridgeSize)) {
                return true;
            }
            throw new IllegalArgumentException("[ERROR] 3-20사이의 숫자를 입력해주세요!");
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요!");
        }
    }

    public boolean readMovingValidator(String input) {
        return input.equals("U") || input.equals("D");
    }
}
