package bridge.view;

import bridge.util.Validate;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private Validate validate = new Validate();
    private OutputView outputView = new OutputView();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        outputView.printSetSize();
        String size = Console.readLine();
        validateSize(size);
        return Integer.parseInt(size);
    }

    private void validateSize(String size) {
        try {
            validate.validateBridgeSize(size);
        }
        catch(IllegalArgumentException e){
            outputView.printException(e);
            readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printMove();
        String move = Console.readLine();
        validateMove(move);
        return move;
    }

    private void validateMove(String move) {
        try {
            validate.validateMoving(move);
        }
        catch(IllegalArgumentException e){
            outputView.printException(e);
            readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
