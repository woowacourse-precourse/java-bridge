package bridge;

import camp.nextstep.edu.missionutils.Console;

import static message.ErrorMessage.*;
import static message.PrintMessage.MOVE_D_COMMAND;
import static message.PrintMessage.RETRY_R_COMMAND;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private BridgeGame bridgeGame;


    public int readBridgeSize() {
        try {
            this.bridgeGame = new BridgeGame(Integer.parseInt(Console.readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(BRIDGE_LENGTH_ERROR.getStatus());
            this.readBridgeSize();
        }
        return bridgeGame.getSize();
    }


    public String readMoving() {
        try {
            this.bridgeGame = new BridgeGame(Console.readLine(),RETRY_R_COMMAND.getStatus());
        } catch (IllegalArgumentException e) {
            System.out.println(MOVE_COMMAND_ERROR.getStatus());
            this.readMoving();
        }
        return bridgeGame.getReadMoving();
    }


    public String readGameCommand() {
        try {
            this.bridgeGame = new BridgeGame(MOVE_D_COMMAND.getStatus(), Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(RETRY_COMMAND_ERROR.getStatus());
            this.readGameCommand();
        }
        return bridgeGame.getGameCommand();
    }
}
