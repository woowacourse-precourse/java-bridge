package bridge;

public class InputRestartValidator {

    public static void validate(String input) {
        if(inputIsNotRAndIsNotQ(input)) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q만 입력 가능합니다.");
        }
    }

    private static boolean inputIsNotRAndIsNotQ(String input) {
        return !(input.equals("R") || input.equals("Q"));
    }
}
