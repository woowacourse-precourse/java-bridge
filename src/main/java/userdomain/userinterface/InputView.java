package userdomain.userinterface;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputBridgeSize() {
        String bridgeSize = Console.readLine();
        return bridgeSize;
    }

    public String inputUserMoving() {
        String move = Console.readLine();
        return move;
    }

    public String inputReGame() {
        String reGame = Console.readLine();
        return reGame;
    }

}
