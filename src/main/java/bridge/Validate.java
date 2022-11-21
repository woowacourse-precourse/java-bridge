package bridge;

public class Validate {
    private final String ERROR = "[ERROR]";

    public void validateNumberRange(String input, int min, int max) {
        if (!input.matches("[0-9]")) {
            throw new IllegalArgumentException(ERROR + " 숫자만 입력 가능합니다.");
        }
        int num = Integer.parseInt(input);
        if (num < min || num > max) {
            throw new IllegalArgumentException(ERROR + min + "이상 " + max + "이하의 숫자만 가능합니다.");
        }
    }

    public void validateContainWord(String input, String word1, String word2) {
        if (!input.equals(word1) && !input.equals(word2)) {
            throw new IllegalArgumentException(ERROR + word1 + " 또는 " + word2 + "만 입력 가능합니다.");
        }
    }
}
