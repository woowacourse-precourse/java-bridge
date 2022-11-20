package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        int bridgeSize = Integer.parseInt(Console.readLine());
        return bridgeSize;
    }

    public String readMoving() {
        String movingLocation = Console.readLine();
        return movingLocation;
    }

    public String readGameCommand() {
        String command = Console.readLine();
        return command;
    }
}
