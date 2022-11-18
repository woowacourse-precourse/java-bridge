package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeRandomNumberGenerator;
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

    public BridgeController() {
        inputView = new InputView();
        outputView = new OutputView();

        BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        bridgeGame = new BridgeGame(numberGenerator);
    }

    public void run() {
        bridgeSize = inputView.readBridgeSize();
        completeness = false;

        bridgeGame.initGame(bridgeSize);
        List<String> bridge = bridgeGame.getBridge();

        while (!completeness) {
            List<String> result = move();

            outputView.printMap(bridge, result);
        }
    }

    private List<String> move() {
        String moving = inputView.readMoving();

        MovingResultDto resultDto = bridgeGame.move(moving);

        completeness = resultDto.getCompleteness();

        return resultDto.getResult();
    }
}
