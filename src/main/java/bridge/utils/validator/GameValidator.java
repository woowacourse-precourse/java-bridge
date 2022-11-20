package bridge.utils.validator;

public class GameValidator {

    public static void validMovingOption(String movingOption) {
        if (!movingOption.equals("U") || !movingOption.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D를 통해서 움직일 수 있습니다.");
        }
    }
}
