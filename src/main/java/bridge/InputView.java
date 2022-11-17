package bridge;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    Validator validator = new Validator();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String lenString = Console.readLine();
        int len = validator.isInt(lenString);
        return validator.isValidLength(len);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public boolean readMoving() {
        String moveString = Console.readLine();
        validator.isValidMove(moveString);
        if (moveString.equals("U")) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        return false;
    }
}
