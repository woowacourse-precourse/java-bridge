package bridge.View;

import bridge.Enum.BridgeGameInfo;
import bridge.Validator.Integarated.BridgeSizeValidator;
import bridge.Validator.Integarated.PlayerMoveValidator;
import bridge.Validator.Integarated.RestartDecisionValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public InputView() {}
    BridgeSizeValidator bridgeSizeValidator = new BridgeSizeValidator();
    PlayerMoveValidator playerMoveValidator = new PlayerMoveValidator();
    RestartDecisionValidator restartDecisionValidator = new RestartDecisionValidator();

    public int readBridgeSize() {
        try {
            String input = getInput();
            bridgeSizeValidator.validate(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }
    public String readMoving() {
        try {
            String input = getInput();
            playerMoveValidator.validate(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    public String readGameCommand() {
        try {
            String input = getInput();
            restartDecisionValidator.validate(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }

    }

    public String getInput() {
        return Console.readLine();
    }

}

