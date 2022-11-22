package bridge.view;

import bridge.util.Validater;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private Validater validater = new Validater();

    public int readBridgeSize() {
        String input = Console.readLine();
        System.out.println();
        validater.validateBridgeSize(input);
        int bridgeSize = convertToIntSize(input);
        return bridgeSize;
    }

    public String readMoving() {
        String moveCommand = Console.readLine();
        validater.validateMovingInput(moveCommand);
        return moveCommand;
    }

    public String readGameCommand() {
        String gameCommand = Console.readLine();
        validater.validateGameCommandInput(gameCommand);
        return gameCommand;
    }

    private int convertToIntSize(String input) {
        return Integer.valueOf(input);
    }
}
