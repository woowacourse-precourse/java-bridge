package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import bridge.model.BridgeSizeValidator;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        try {
            return Integer.parseInt(bridgeSize);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.DIGIT.getErrorMsg());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = Console.readLine();
        if( !(move.equals(Constants.UP) || move.equals(Constants.DOWN)) ) {
            throw new IllegalArgumentException(ErrorMessage.MOVE.getErrorMsg());
        }
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine();
        if( !(command.equals(Constants.RESTART) || command.equals(Constants.EXIT)) ) {
            throw new IllegalArgumentException(ErrorMessage.COMMAND.getErrorMsg());
        }
        return command;
    }


}