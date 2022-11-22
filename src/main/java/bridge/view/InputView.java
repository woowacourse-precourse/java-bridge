package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        try {
            OutputView.outputEnterBridgeSize();
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public String readMoving() {
        OutputView.outputChooseMovePosition();
        return Console.readLine();
    }

    public String readGameCommand() {
        OutputView.outputChooseRestartOrQuit();
        return Console.readLine();
    }

}
