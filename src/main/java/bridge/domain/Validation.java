package bridge.domain;

public class Validation {
    public static void isNumber(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }

    public static void inRange(String input) throws IllegalArgumentException {
        int number = Integer.parseInt(input);
        if ((number < 3) || (number > 20)) {
            throw new IllegalArgumentException("[ERROR] 숫자가 3에서 20 사이의 값이 아닙니다.");
        }
    }

    public static void isUorD(String input) throws IllegalArgumentException {
        if (!(input.equals("U")) && !(input.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] U나 D 값을 입력해주세요.");
        }
    }

    public static void isRorQ(String input) throws IllegalArgumentException {
        if (!(input.equals("R")) && !(input.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] R이나 Q 값을 입력해주세요.");
        }
    }
}
