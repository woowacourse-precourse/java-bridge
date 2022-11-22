package bridge.view;

import bridge.model.constants.GameMessage;
import camp.nextstep.edu.missionutils.Console;


public class InputView {

    public int readBridgeSize() {
        System.out.println(GameMessage.OUTPUT_INIT_GAME + "\n\n"
                            + GameMessage.INPUT_BRIDGE_SIZE);

        int inputSize = Integer.parseInt(Console.readLine());
        System.out.println(" ");
        return inputSize;
    }

    public String readMoving() {
        System.out.println(GameMessage.INPUT_MOVING_COMMAND);
        return Console.readLine();
    }

    public String readGameCommand() {
        System.out.println(GameMessage.INPUT_RESTARTING_COMMAND);
        return Console.readLine();
    }
}
