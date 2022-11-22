package bridge;

public class Progress {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static BridgeGame bridgeGame;
    private static boolean loop = true;
    
    public void makeBridge() {
        while (true) {
            try {
                bridgeGame = new BridgeGame(inputView.readBridgeSize());
                System.out.println(" ");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(outputView.errorMessage(e.getMessage()));
            }
        }
    }

    public void gameInProcess() {
        while (loop) {
            try {
                movingProcess();
            } catch (IllegalArgumentException e) {
                System.out.println(outputView.errorMessage(e.getMessage()));
            }
        }
    }

    public void movingProcess() {
        while (!bridgeGame.isMoveFinish()) {
            loop = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.inputHistory());
        }
    }


}
