package bridge.controller;

import static bridge.domain.GameCommand.QUIT;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.GameCommand;
import bridge.domain.MoveResult;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController implements GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameController(InputView inputView, OutputView outputView,
        BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void execute() {
        outputView.printGameStartMessage();
        BridgeGame bridgeGame = generateBridgeGame();
        while (true) {
            if (play(bridgeGame, inputView, outputView).equals(QUIT)) {
                outputView.printResult(bridgeGame.getMoveResult());
                break;
            }
        }
    }

    private BridgeGame generateBridgeGame() {
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        MoveResult moveResult = new MoveResult();
        return new BridgeGame(bridge, moveResult);
    }

    public static GameCommand play(BridgeGame bridgeGame, InputView inputView, OutputView outputView) {
        for (int i = 0; i < bridgeGame.getBridgeSize(); i++) {
            bridgeGame.move(i, inputView.readMoving());
            outputView.printMap(bridgeGame.getMoveResult());
            if (!bridgeGame.getMoveResult().isSuccess()) {
                return bridgeGame.retry(inputView.readGameCommand());
            }
        }
        return QUIT;
    }
}
