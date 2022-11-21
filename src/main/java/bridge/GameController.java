package bridge;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final BridgeGame bridgeGame = new BridgeGame();

    void startGame() throws CloneNotSupportedException {
        boolean retryFlag = true;
        boolean gameSuccess = false;
        setBridgeGame();
        while(retryFlag) {
            bridgeGame.initUserBridge();
            gameSuccess = move();
            if(gameSuccess) break;

            retryFlag = retryGame();
        }
        outputView.printResult(gameSuccess, bridgeGame.getGameCount(), bridgeGame.getBridge(), bridgeGame.getUserBridge());
    }

    private void setBridgeGame(){
        int size = inputBridgeSize();

        bridgeGame.initBridge(size);
    }

    private int inputBridgeSize(){
        while(true){
            try {
                outputView.printInputBridgeSize();
                return inputView.readBridgeSize();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

    }

    private boolean move() throws CloneNotSupportedException {
        boolean gameSuccess = true;
        while(gameSuccess && !bridgeGame.checkGameEnd()) {
            String input = inputMoving();

            gameSuccess = !bridgeGame.move(input);
            outputView.printMap(bridgeGame.getBridge(),bridgeGame.getUserBridge());
        }
        return gameSuccess;
    }

    private String inputMoving(){
        while(true){
            try{
                outputView.printInputMoving();
                return inputView.readMoving();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private String inputRetryFlag(){
        while(true) {
            try {
                outputView.printInputAgain();
                return inputView.readGameCommand();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean retryGame() throws CloneNotSupportedException {
        String retryFlag = inputRetryFlag();

        return bridgeGame.retry(retryFlag);
    }
}
