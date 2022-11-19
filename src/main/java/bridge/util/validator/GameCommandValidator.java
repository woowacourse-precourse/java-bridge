package bridge.util.validator;

public class GameCommandValidator {
    public static void validate(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] R이나 Q만 입력해야 합니다");
        }
    }
}
