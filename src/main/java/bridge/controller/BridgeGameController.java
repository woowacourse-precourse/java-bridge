package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeSize;
import bridge.domain.bridge.Square;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.BridgeResult;
import bridge.domain.game.Command;
import bridge.dto.BridgeResultDto;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final BridgeGame bridgeGame;

    private BridgeResult bridgeResult;

    public BridgeGameController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        outputView.printInit();
        BridgeSize bridgeSize = new BridgeSize(inputView.readBridgeSize());

        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> tempBridge = bridgeMaker.makeBridge(bridgeSize.getSize());
        Bridge bridge = Bridge.valueOf(tempBridge);
        bridgeResult = new BridgeResult();

        while (bridgeGame.inProgress()) {
            String move = inputView.readMoving();
            Square userMove = new Square(move);

            int position = bridgeGame.getPosition();
            boolean result = bridge.canMoveForward(userMove, position);

            bridgeResult.updateResult(userMove, result);
            BridgeResultDto bridgeResultDto = bridgeResult.toDto();

            outputView.printMap(bridgeResultDto);

            if (result) {
                bridgeGame.move(bridgeSize.getSize());
            } else {
                Command command = new Command(inputView.readGameCommand());
                isExitSetGameStatus(command);
                isRetryInitializeGame(command);
            }

            if (bridgeGame.isGameSuccess(bridgeSize.getSize())) {
                bridgeGame.exit();
            }
        }
    }

    private void isExitSetGameStatus(Command command) {
        if (command.isExitCommand()) {
            bridgeGame.exit();
        }
    }

    private void isRetryInitializeGame(Command command) {
        if (command.isRetryCommand()) {
            bridgeGame.retry();
            bridgeResult = new BridgeResult();
        }
    }
}
