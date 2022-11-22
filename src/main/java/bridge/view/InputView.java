package bridge.view;

import bridge.view.validation.InputValidation;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private InputValidation validation = new InputValidation();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        boolean isDigit = false;
        String readLine = "";
        while (isFinish(isDigit)) {
            OutputView.printInputBridgeSizeMessage();
            readLine = Console.readLine();
            isDigit = validation.isBridgeSizeValid(readLine, isDigit);
        }
        return Integer.parseInt(readLine);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        boolean isPattern = false;
        String position = "";
        while (isFinish(isPattern)) {
            OutputView.printInputMoveMessage();
            position = Console.readLine();
            isPattern = validation.isMovePositionValid(position, isPattern);
        }
        return position;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        boolean isPattern = false;
        String gameCommand = "";
        while (isFinish(isPattern)) {
            OutputView.printInputGameCommandMessage();
            gameCommand = Console.readLine();
            isPattern = validation.isGameCommandValid(gameCommand, isPattern);
        }
        return gameCommand;
    }

    private boolean isFinish(boolean isBoolean) {
        return !Boolean.TRUE.equals(isBoolean);
    }
}
