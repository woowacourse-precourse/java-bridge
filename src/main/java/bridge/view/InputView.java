package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.view.Message.INPUT_BRIDGE_LENGTH;
import static bridge.view.Message.INPUT_RETRY;
import static bridge.view.Message.INPUT_STATE;
import static bridge.view.Message.PRINT_START_MESSAGE;

public class InputView {

    public String readBridgeSize() {
        System.out.println(PRINT_START_MESSAGE);
        System.out.println(INPUT_BRIDGE_LENGTH);
        return Console.readLine();
    }

    public String readMoving() {
        System.out.println(INPUT_STATE);
        String move = Console.readLine();
        return move;
    }

    public String readGameCommand() {
        System.out.println(INPUT_RETRY);
        String move = Console.readLine();
        return move;
    }}
