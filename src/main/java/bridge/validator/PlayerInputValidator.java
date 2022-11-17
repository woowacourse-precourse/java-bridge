package bridge.validator;

public class PlayerInputValidator {

    public void canMove(String input) {
        if (!(input.equals("U") || input.equals("P"))) {
            throw new IllegalArgumentException("[ERROR] 이동하기 위해서는 U와 D만 입력 가능합니다.");
        }
    }
}
