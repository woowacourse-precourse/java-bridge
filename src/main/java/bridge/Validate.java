package bridge;

public class Validate {
    private final String error = "[ERROR]";

    public void validateNumberRange(String input, int min, int max) {
        if (!input.matches("[0-9]")) {
            throw new IllegalArgumentException(error + " 숫자만 입력 가능합니다.");
        }
        int num = Integer.parseInt(input);
        if (num < min || num > max) {
            throw new IllegalArgumentException(error + min + "이상 " + max + "이하의 숫자만 가능합니다.");
        }
    }
}
