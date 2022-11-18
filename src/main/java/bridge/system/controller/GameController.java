package bridge.system.controller;

import bridge.service.BridgeGame;
import bridge.system.util.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.vo.Bridge;
import bridge.vo.GameResult;
import bridge.vo.Step;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;

    public GameController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
        this.bridgeGame = bridgeGame;
    }

    public void doGame() {
        outputView.printGameStartMessage();

        Bridge bridge = makeBridge();
        GameResult gameResult = bridgeGame.doGame(bridge);
        handleGameResult(bridge, gameResult);
    }

    private static void handleGameResult(Bridge bridge, GameResult gameResult) {
        if (bridge.size() == gameResult.getStepResults().size()) {
            handleSuccess(gameResult);
        }
        if (bridge.size() != gameResult.getStepResults().size()) {
            handleFailure(gameResult);
        }
    }

    private static void handleSuccess(GameResult gameResult) {
        System.out.println("gameResult.getTryCount() = " + gameResult.getTryCount());
        System.out.println("성공");
        //TODO
    }

    private static void handleFailure(GameResult gameResult) {
        System.out.println("gameResult.getTryCount() = " + gameResult.getTryCount());
        System.out.println("중도 포기");
        //TODO
    }

    private Bridge makeBridge() {
        outputView.printAskingBridgeSizeMessage();
        int bridgeSize = inputView.readBridgeSize();

        List<Step> steps = Step.from(bridgeMaker.makeBridge(bridgeSize));
        return new Bridge(steps);
    }
}
