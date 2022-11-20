package bridge;


public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;
    private int tryCount;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void makeBridgeGame() {
        int bridgeSize;
        outputView.printStartGame();
        bridgeSize = inputView.readBridgeSize();
        this.bridgeGame = new BridgeGame(bridgeSize);
    }

    public void playBridgeGame() {
        tryCount = 1;

        for (int currentStep = 0;currentStep< bridgeGame.getBridgeSize();currentStep++){
            playRound(currentStep);
        }
    }

    public void playRound(int currentStep) {
        outputView.printQuestion();
        String currentMoving = inputView.readMoving();
        bridgeGame.move(currentMoving);
        String[] map = makeMap(bridgeGame);
        outputView.printMap(map);
    }

    public String[] makeMap(BridgeGame bridgeGame) {
        return new String[2];
    }

    public String makeUpSide() {
        return "";
    }

    public String makeDownSide() {
        return "";
    }

}
