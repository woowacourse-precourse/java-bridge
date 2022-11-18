package bridge;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

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
    public boolean readMoving(List<String> moves) {
        String moveString = Console.readLine();
        validator.isValidMove(moveString);
        moves.add(moveString); // does this work?
        return (moveString.equals("U"));
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        String commandString = Console.readLine();
        validator.isValidCommand(commandString);
        return (commandString.equals("R"));
    }
}
