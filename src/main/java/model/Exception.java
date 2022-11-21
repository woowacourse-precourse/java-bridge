package model;

public class Exception {
    public Boolean isEmpty(String checkEmpty) {
        return checkEmpty.isEmpty() || checkEmpty.isBlank();
    }

    public Boolean isRangeInThreeAndTwenty(int bridgeSize) {
        return bridgeSize < 3 || bridgeSize > 20;
    }

    public Boolean isNumber(String bridgeSize) {
        return bridgeSize.chars().allMatch(Character::isDigit);
    }

    public Boolean isUorD(String moving) {
        return moving.equals("U") || moving.equals("D");
    }

    public Boolean isRorQ(String command) {
        return command.equals("R") || command.equals("Q");
    }
}
