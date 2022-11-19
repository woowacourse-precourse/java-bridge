package bridge;

public class InputMoveValidator {

    public static void validate(String input) {

        if(isNotUAndIsNotB(input)) {
            throw new IllegalArgumentException("[ERROR] U 또는 D만 입력 가능합니다.");
        }
    }

    public static boolean isNotUAndIsNotB(String input) {
        return !(input.equals("U") || input.equals("D"));
    }

}
