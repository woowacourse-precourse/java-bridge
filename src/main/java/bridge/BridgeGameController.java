package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridgeGame = new BridgeGame(inputView.readBridgeSize(), bridgeMaker);
    }


    public void start() {
        String movingCommand = inputView.readMoving();
        String sign = bridgeGame.move(movingCommand);
        // 결과 출력 : OutputView #printMap

    }
}