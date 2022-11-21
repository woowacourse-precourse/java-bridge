package bridge;
import bridge.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 *
 * 제공된 InputView 클래스를 활용해 구현해야 한다.
 * InputView의 패키지는 변경할 수 있다.
 * InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class InputView {
    Validator validator = new Validator();
    OutputView output = new OutputView();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        output.printGetLength();
        String lenString = Console.readLine();
        int len = validator.isInt(lenString);
        return validator.isValidLength(len);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        output.printGetMove();
        String move = Console.readLine();
        validator.isValidMove(move);
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        output.printGetCommand();
        String command = Console.readLine();
        validator.isValidCommand(command);
        return command;
    }
}
