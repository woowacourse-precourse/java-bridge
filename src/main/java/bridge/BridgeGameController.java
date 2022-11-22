package bridge;

public class BridgeGameController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    /**
    public void play(){
        outputView.startGameMessage();
        List<String> bridge = createBridge(inputView.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge);

        startGame(bridgeGame);
        outputView.printResult(bridgeGame.getTopResult(), bridgeGame.getBottomResult(), bridgeGame.successOrFailure(), bridgeGame.getTotalPlayCnt());
    }
     **/
}
