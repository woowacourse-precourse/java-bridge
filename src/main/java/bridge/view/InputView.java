package bridge.view;

import bridge.handler.InputBridgeLengthHandler;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private String bridgeLength;
    InputBridgeLengthHandler inputBridgeLengthHandler = new InputBridgeLengthHandler(bridgeLength);

    public String readBridgeSize() {
        PrintView printView = new PrintView();

        System.out.println(printView.START_ORDER);
        printView.lineSkip();
        System.out.println(printView.INPUT_BRIDGE_LENGTH);
        String bridgeLength = inputBridgeLengthHandler.checkValidator(Console.readLine());
        printView.lineSkip();

        return bridgeLength;
    }

    public String readGameCommand() {
        return Console.readLine();
    }
}
