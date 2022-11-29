package bridge.view;

import bridge.util.Validate;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private OutputView outputView = new OutputView();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(Validate validate) {
        outputView.printSetSize();
        try {
            String size = Console.readLine();
            validate.validateBridgeSize(size);
            return Integer.parseInt(size);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return readBridgeSize(validate);
        }
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(Validate validate) {
        outputView.printMove();
        try {
            String move = Console.readLine();
            validate.validateMoving(move);
            return move;
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return readMoving(validate);
        }
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(Validate validate) {
        outputView.printRestart();
        try {
            String gameDestination = Console.readLine();
            validate.validateGameDefinition(gameDestination);
            return gameDestination;
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return readGameCommand(validate);
        }
    }

}
