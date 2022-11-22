package bridge.validator;

public class GameCommandValidator {
    private static final String RESTART = "R";
    private static final String QUIT = "Q";

    public static boolean isRestartOrQuit(String input) {
        if (input.equals(RESTART) || input.equals(QUIT)) {
            return true;
        }
        return false;
    }

    public static void validateGameCommand(String input) {
        if (!isRestartOrQuit(input)) {
            throw new IllegalArgumentException("게임 재시작/종료 여부는 R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있습니다.");
        }
    }
}
