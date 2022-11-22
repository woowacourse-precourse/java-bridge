package bridge.view.validation;


import bridge.type.PositionType;
import bridge.type.RetryType;

public class InputValidation {

    public boolean isBridgeSizeValid(String readLine, boolean isDigit) {
        try {
            isDigit = isDigits(readLine);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return isDigit;
    }

    public boolean isMovePositionValid(String readLine, boolean isPattern) {
        try {
            isPattern = isPositionPattern(readLine);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return isPattern;
    }

    public boolean isGameCommandValid(String readLine, boolean isPattern) {
        try {
            isPattern = isRetryPattern(readLine);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return isPattern;
    }

    private boolean isDigits(String readLine) {
        if (!readLine.chars().allMatch(Character::isDigit) || readLine.chars().anyMatch(value -> value == ' ')) {
            throw new IllegalArgumentException("[ERROR] Bridge size is Exception !!");
        }
        return true;
    }

    private boolean isPositionPattern(String readLine) {
        if (!(PositionType.UP.getPositionSymbol().equals(readLine) || PositionType.DOWN.getPositionSymbol().equals(readLine))) {
            throw new IllegalArgumentException("[ERROR] PositionType is Exception !!");
        }
        return true;
    }

    private boolean isRetryPattern(String readLine) {
        if (!(RetryType.RETRY.getSymbol().equals(readLine) || RetryType.END.getSymbol().equals(readLine))) {
            throw new IllegalArgumentException("[ERROR] RetryType is Exception !!");
        }
        return true;
    }
}
