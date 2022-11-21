package bridge.view.io;

import static bridge.message.SystemMessage.GAME_RESULT;
import static bridge.message.SystemMessage.GAME_START;
import static bridge.message.SystemMessage.INPUT_BRIDGE_SIZE;
import static bridge.message.SystemMessage.INPUT_MOVING;
import static bridge.message.SystemMessage.RETRY;

import bridge.domain.bridge.BridgeSize;
import bridge.value.BridgeCharacter;
import bridge.value.GameCommand;
import bridge.view.game.GameResultView;
import bridge.view.game.GameStatusView;

public class UserIOView {
    private final InputView inputView;
    private final OutputView outputView;

    public UserIOView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public BridgeCharacter inputMovingCharacterProcess() {
        outputView.printMessage(INPUT_MOVING);
        return inputValidReadMoving();
    }

    public GameCommand inputGameCommandProcess(GameStatusView gameStatusView) {
        outputView.printMap(gameStatusView);

        outputView.printMessage(RETRY);
        return inputValidGameCommand();
    }

    public void initProcess() {
        outputView.printMessage(GAME_START);
        outputView.lineSeparate();
    }

    public BridgeSize inputBridgeSizeProcess() {
        outputView.printMessage(INPUT_BRIDGE_SIZE);

        BridgeSize readBridgeSize = inputValidBridgeSize();

        outputView.lineSeparate();
        return readBridgeSize;
    }

    public void outputGameStatus(GameStatusView gameStatusView) {
        outputView.printMap(gameStatusView);
    }

    public void releaseProcess(GameResultView gameResultView) {
        outputView.printMessage(GAME_RESULT);
        outputView.printResult(gameResultView);
    }

    private BridgeSize inputValidBridgeSize() {
        try {
            return inputView.readBridgeSize();

        } catch (IllegalArgumentException illegalArgumentException) {

            outputView.println(illegalArgumentException.getMessage());
            return inputValidBridgeSize();
        }
    }

    private BridgeCharacter inputValidReadMoving() {
        try {
            return inputView.readMoving();

        } catch (IllegalArgumentException illegalArgumentException) {

            outputView.println(illegalArgumentException.getMessage());
            return inputValidReadMoving();
        }
    }

    private GameCommand inputValidGameCommand() {
        try {
            return inputView.readGameCommand();
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.println(illegalArgumentException.getMessage());
            return inputValidGameCommand();
        }
    }
}
