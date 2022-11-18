package bridge.presentation;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        int bridgeSize = Integer.parseInt(Console.readLine());
        return bridgeSize;
    }//readBridgeSize

    public String readMoving() {
        String movement = Console.readLine();
        return movement;
    }//readMoving

    public String readGameCommand() {
        String command = Console.readLine();
        return command;
    }//readGameCommand
}// end class
