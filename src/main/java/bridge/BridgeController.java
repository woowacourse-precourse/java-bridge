package bridge;


public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        this.bridgeGame = new BridgeGame(inputView.readBridgeSize());
        while (play()) {
            if (bridgeGame.isEnd())
                break;
        }

        outputView.printResult(bridgeGame.getBridgeUpMemory(),bridgeGame.getBridgeDownMemory(),bridgeGame.isEnd(),bridgeGame.getGameTryCount());
    }

    public boolean play() {
        if(bridgeGame.move(inputView.readMoving()))
            return true;
        return false;
    }
}
