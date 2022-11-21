package bridge;

public class Validator {

    public static void validateNumeric(String input) {
        try {
            int parsed = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형태의 입력이 아닙니다.");
        }
    }

    public static void validateNumericSize(int minLength, int maxLength, String input) {
        int parsed = Integer.parseInt(input);

        if (parsed < minLength || parsed > maxLength) {
            throw new IllegalArgumentException("[ERROR] 숫자의 범위는 " + minLength + " ~ " + maxLength + "입니다.");
        }
    }

}
