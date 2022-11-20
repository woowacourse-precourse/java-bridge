package bridge;


public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMap bridgeMap;
    private BridgeGame bridgeGame;
    private int tryCount;


    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMap = new BridgeMap();
    }

    public void makeBridgeGame() {
        int bridgeSize;
        outputView.printStartGame();
        bridgeSize = inputView.readBridgeSize();
        this.bridgeGame = new BridgeGame(bridgeSize);
        System.out.println("bridgeGame.getBridge() = " + bridgeGame.getBridge());
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
        String[] map = bridgeMap.makeMap(bridgeGame);
        outputView.printMap(map);
    }



}
