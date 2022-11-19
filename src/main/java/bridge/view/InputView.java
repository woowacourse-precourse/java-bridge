package bridge.view;

import bridge.Exception.CommandException;
import bridge.Exception.MoveException;
import bridge.Exception.Validation;
import camp.nextstep.edu.missionutils.Console;

import java.util.function.Function;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();

        return (Integer) validateInput(Integer::parseInt, input, "R와 Q 중 하나만 입력하세요");
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();

        return (String) validateInput(Validation::validateMove, input, "U와 D 중 하나만 입력하세요");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();

        return (String) validateInput(Validation::validateCommand, input, "R와 Q 중 하나만 입력하세요");
    }

    private Object validateInput(Function<String, Object> callback, String input, String message){
        try {
            return callback.apply(input);
        } catch (NumberFormatException | CommandException | MoveException e) {
            throw new IllegalArgumentException(message);
        }
    }
}
