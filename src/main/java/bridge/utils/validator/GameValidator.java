package bridge.utils.validator;

public class GameValidator {

    public static void validMovingOption(String movingOption) {
        if (!movingOption.equals("U") || !movingOption.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D를 통해서 움직일 수 있습니다.");
        }
    }

    public static void validGameCommand(String gameCommand) {
        if (!gameCommand.equals("R") || !gameCommand.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q를 통해 재시작 여부를 입력해주세요");
        }
    }
}
