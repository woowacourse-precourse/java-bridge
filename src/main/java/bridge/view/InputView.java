package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.constant.BridgePhrase;
import bridge.domain.resources.bridge.BridgeSize;
import bridge.domain.resources.GameCommand;
import bridge.domain.resources.Move;
import bridge.utils.parser.BridgeSizeInputParser;
import bridge.utils.parser.GameCommandInputParser;
import bridge.utils.parser.MoveInputParser;

public class InputView {

    public final BridgeSize readBridgeSize() {
        String bridgeSizeInput = inputWithMessage(BridgePhrase.INPUT_BRIDGE_SIZE);
        try {
            return BridgeSizeInputParser.parseBridgeSize(bridgeSizeInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    public final Move readMoving() {
        String moveInput = inputWithMessage(BridgePhrase.INPUT_MOVE);
        try {
            return MoveInputParser.parseMove(moveInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    public final GameCommand readGameCommand() {
        String gameCommandInput = inputWithMessage(BridgePhrase.INPUT_GAME_COMMAND);
        try {
            return GameCommandInputParser.parseGameCommand(gameCommandInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    private String inputWithMessage(final BridgePhrase message) {
        System.out.println(message.getMessage());
        return inputBasicLine();
    }

    private String inputBasicLine() {
        return readLine();
    }
}