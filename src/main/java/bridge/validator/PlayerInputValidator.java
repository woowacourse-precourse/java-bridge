package bridge.validator;

public class PlayerInputValidator {

    public static void canMove(final String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 이동하기 위해서는 U와 D만 입력 가능합니다.");
        }
    }

    public static void canFinish(final String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] P와 Q를 통해서만 재시작, 종료가 가능합니다.");
        }
    }
}
