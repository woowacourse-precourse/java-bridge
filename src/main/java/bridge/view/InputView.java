package bridge.view;

import bridge.model.Command;
import bridge.model.Direction;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException{
        //TODO: IllegalArgument
        try{
            return Integer.parseInt(Console.readLine());
        }catch (NumberFormatException nfe){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Direction readMoving() {
        return Direction.fromSymbol(Console.readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public Command readGameCommand() {
        return Command.fromSymbol(Console.readLine());
    }
}
