package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.GameResult;
import bridge.dto.MovingResultDto;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    private int bridgeSize;
    private boolean completeness;
    private boolean success;

    private List<String> result;

    public BridgeController() {
        inputView = new InputView();
        outputView = new OutputView();

        BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        bridgeGame = new BridgeGame(numberGenerator);
    }

    public List<String> settingBridge() {
        outputView.printStart();
        bridgeSize = inputView.readBridgeSize();

        bridgeGame.settingBridge(bridgeSize);
        bridgeGame.initGame();

        return bridgeGame.getBridge();
    }

    public boolean run(List<String> bridge) {
        completeness = false;
        success = false;

        while (!completeness) {
            result = move();

            outputView.printMap(bridge, result);
        }

        if (!success) {
            String retry = inputView.readGameCommand();

            if (retry.equals("R")) {
                return bridgeGame.retry();
            }
        }

        return false;
    }

    public void ending(List<String> bridge) {
        int tryCount = bridgeGame.getTryCount();

        GameResult gameResult = GameResult.getGameResult(success);

        outputView.printEndingPhrase();
        outputView.printMap(bridge, result);
        outputView.printResult(gameResult, tryCount);
    }

    private List<String> move() {
        String moving = inputView.readMoving();

        MovingResultDto resultDto = bridgeGame.move(moving);

        completeness = resultDto.getCompleteness();
        success = resultDto.getSuccess();

        return resultDto.getResult();
    }

}
