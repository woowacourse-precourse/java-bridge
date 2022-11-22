package bridge;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    
    public BridgeGameController() {
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    private void runPhase(BridgeGame bridgeGame) {
        while (!bridgeGame.isCompleted()) {
            bridgeGame.move(inputView.getMoving());
            outputView.printMap(bridgeGame);
            if (bridgeGame.isCorrect()) continue;
            if (inputView.getGameCommand().equals(GameCommand.RETRY.getCommand())) {
                bridgeGame.retry();
                continue;
            }
            bridgeGame.saveCurrentPlay();
            break;
        }
    }

}
