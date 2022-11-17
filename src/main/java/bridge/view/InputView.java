package bridge.view;

import bridge.standard.Bug;
import camp.nextstep.edu.missionutils.Console;

public class InputView {


    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        try {
            Bug.validateChar(bridgeSize, Bug.SIZE_PATTERN, Bug.INPUT_ONLY_NUMBER);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readBridgeSize();
        }
        return toInt(bridgeSize);
    }

    private int toInt(String bridgeSize) {
        int size = Integer.parseInt(bridgeSize);
        try {
            Bug.validateNumber(size, Bug.INPUT_BETWEEN_THREE_AND_TWENTY);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readBridgeSize();
        }
        return size;

    }

    public String readMoving() {
        String moving = Console.readLine();
        try {
            Bug.validateChar(moving, Bug.MOVING_PATTERN, Bug.INPUT_U_OR_D);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readMoving();
        }
        return moving;
    }

    public String readGameCommand() {
        String gameCommand = Console.readLine();
        try {
            Bug.validateChar(gameCommand, Bug.GAME_COMMAND_PATTERN, Bug.INPUT_R_OR_Q);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readGameCommand();
        }
        return gameCommand;
    }


}
