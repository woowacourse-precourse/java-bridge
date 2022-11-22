package bridge.view;

import bridge.handler.InputBridgeLengthHandler;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    InputBridgeLengthHandler inputBridgeLengthHandler = new InputBridgeLengthHandler();

    public String readBridgeSize() {
        PrintView printView = new PrintView();

        System.out.println(printView.START_ORDER);
        printView.lineSkip();
        System.out.println(printView.INPUT_BRIDGE_LENGTH);
        String bridgeLength = loopInputBridgeLength();
        printView.lineSkip();

        return bridgeLength;
    }

    private String loopInputBridgeLength() {
        try {
            String bridgeLength = readGameCommand();
            inputBridgeLengthHandler.checkValidator(bridgeLength);
            return bridgeLength;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return loopInputBridgeLength();
        }
    }

    public String readGameCommand() {
        return Console.readLine();
    }
}