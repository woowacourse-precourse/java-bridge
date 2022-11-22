package bridge.view;

import bridge.validator.GameCommandValidator;
import bridge.validator.MoveValidator;
import bridge.validator.SizeValidator;
import bridge.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    Validator validator;
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String size = Console.readLine();
        validator = new SizeValidator();
        validator.validate(size);
        return Integer.parseInt(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = Console.readLine();
        move = move.toUpperCase();
        validator = new MoveValidator();
        validator.validate(move);
        return move;
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine();
        command = command.toUpperCase();
        validator = new GameCommandValidator();
        validator.validate(command);
        return command;
    }
}
