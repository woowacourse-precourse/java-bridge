package bridge;

import java.util.List;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private List<String> bridge;

    public String result = "실패";
    public int count;

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    public BridgeController(){
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    public void run(){
        try {
            init();
            play();
        } catch (Exception e) {
            outputView.printException(e);
        }

    }

    private void init(){
        outputView.printGameStart();
        outputView.printBridgeSizeInput();

        int size = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(size);

    }

    private void play(){
        count++;
        BridgeState bridgeState = new BridgeState();
        BridgeGame bridgeGame = new BridgeGame(bridgeState);

        playSubGame(bridgeState, bridgeGame);

        endGame(bridgeState, bridgeGame);

    }

    private void endGame(BridgeState bridgeState, BridgeGame bridgeGame) {
        if (bridgeState.isSuccess(bridge.size())) {
            result = "성공";
            outputView.printResult(result,count, bridgeState.getState());
            return;
        }

        outputView.printRetryInput();
        if (bridgeGame.retry(inputView.readGameCommand())) {
            play();
        }
    }

    private void playSubGame(BridgeState bridgeState, BridgeGame bridgeGame) {
        while (!bridgeGame.isCompleted(bridge.size())) {
            try {
                outputView.printMoveInput();
                bridgeGame.move(inputView.readMoving(),bridge);
                outputView.printMap(bridgeState.getState());
                if (!bridgeGame.isRight()) {
                    break;
                }
            } catch (Exception e) {
                outputView.printException(e);
            }
        }
    }

}
