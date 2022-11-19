package bridge.util;

public class Validator {

    private static final String IS_DIGIT_ERROR = "3이상 20이하 숫자만 입력 가능합니다.";
    private static final String BRIDGE_SIZE_ERROR = "다리길이는 3이상 20이하만 가능합니다.";
    private static final String MOVE_ERROR = "이동은 U,D 만 입력이 가능합니다.";
    private static final String GAME_COMMAND_ERROR = "재시도 R 또는 종료 Q 만 입력 가능합니다.";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RETRY = "R";
    private static final String END = "Q";

    public int canCreateBridge(String number) {
        int changeNumber = toInt(number);
        checkCreateBridgeSize(changeNumber);
        return changeNumber;
    }

    public int toInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException(IS_DIGIT_ERROR);
        }
    }

    public void checkCreateBridgeSize(int number) {
        if (number < 3 || number > 20) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }
    }

    public void canMove(String move) {
        System.out.println(move);
        if (move.equals(UP) || move.equals(DOWN)) {
            return;
        }
        throw new IllegalArgumentException(MOVE_ERROR);
    }

    public void canGameCommand(String gameCommand) {
        if (gameCommand.equals(RETRY) || gameCommand.equals(END)) {
            return;
        }
        throw new IllegalArgumentException(GAME_COMMAND_ERROR);
    }
}
