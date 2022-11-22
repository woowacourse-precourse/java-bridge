package bridge.view;

import bridge.constant.ErrorStatus;
import bridge.model.InputValidation;

import static camp.nextstep.edu.missionutils.Console.readLine;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final OutputView outputView = new OutputView();
    private final InputValidation inputValidation = new InputValidation();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        outputView.printBridgeLength();
        String input = readLine();
        inputValidation.bridgeLengthInputIsNumber(input);
        int number = Integer.parseInt(input);
        inputValidation.bridgeLengthValid(number);
        return number;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printBridgeMove();
        String cmd = readLine();
        inputValidation.moveValid(cmd);
        return cmd;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        outputView.printReTry();
        String cmd = readLine();
        inputValidation.reGameCmdValid(cmd);
        return cmd;
    }
}
