package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.constant.BridgePhrase;
import bridge.domain.resources.GameCommand;
import bridge.domain.resources.Move;
import bridge.domain.resources.bridge.BridgeSize;
import bridge.utils.parser.BridgeSizeInputParser;
import bridge.utils.parser.GameCommandInputParser;
import bridge.utils.parser.MoveInputParser;

public class InputView {

    public BridgeSize readBridgeSize() {
        String bridgeSizeInput = inputWithMessage(BridgePhrase.INPUT_BRIDGE_SIZE);
        BridgeSize bridgeSize;
        try {
            bridgeSize = BridgeSizeInputParser.parseBridgeSize(bridgeSizeInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
        return bridgeSize;
    }

    public Move readMoving() {
        String moveInput = inputWithMessage(BridgePhrase.INPUT_MOVE);
        Move move;
        try {
            move = MoveInputParser.parseMove(moveInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
        return move;
    }

    public GameCommand readGameCommand() {
        String gameCommandInput = inputWithMessage(BridgePhrase.INPUT_GAME_COMMAND);
        GameCommand gameCommand;
        try {
            gameCommand = GameCommandInputParser.parseGameCommand(gameCommandInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
        return gameCommand;
    }

    private String inputWithMessage(final BridgePhrase message) {
        System.out.println(message.getMessage());
        return inputBasicLine();
    }

    public String inputBasicLine() {
        return readLine();
    }
}