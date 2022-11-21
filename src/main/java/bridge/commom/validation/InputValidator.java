package bridge.commom.validation;

public class InputValidator {

    public static void isPositiveInteger(String input) throws IllegalArgumentException {
        String exceptionMessage = "양의 정수만 입력할 수 있습니다.";
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(exceptionMessage);
        }

        if (Integer.parseInt(input) == 0) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static void isMoveCommand(String input) throws IllegalArgumentException {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException("U(위로 이동) 혹은 D(아래로 이동) 중 하나를 입력해야합니다.");
        }
    }

    public static void isRestartCommand(String input) throws IllegalArgumentException {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException("R(재시작) 혹은 Q(종료) 중 하나를 입력해야합니다.");
        }
    }
}
