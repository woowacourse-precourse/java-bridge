package bridge;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final BridgeGame bridgeGame = new BridgeGame();

    private static final int MAX_COUNT = 3;

    void startGame() throws CloneNotSupportedException, IllegalArgumentException {
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

    private int inputBridgeSize() throws IllegalArgumentException{
        int cnt = 0;
        while(true){
            try {
                cnt += 1;
                outputView.printInputBridgeSize();
                return inputView.readBridgeSize();
            }
            catch(Exception e){
                checkInputLimit(cnt);
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

    private String inputMoving() throws IllegalArgumentException{
        int cnt = 0;
        while(true){
            try{
                cnt += 1;
                outputView.printInputMoving();
                return inputView.readMoving();
            }
            catch(Exception e){
                checkInputLimit(cnt);
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkInputLimit(int cnt) throws IllegalArgumentException{
        if (cnt > MAX_COUNT) throw new IllegalArgumentException("[ERROR] 비정상적인 입력이 지속적으로 감지되었습니다.");
    }

    private String inputRetryFlag(){
        int cnt = 0;
        while(true) {
            try {
                cnt += 1;
                outputView.printInputAgain();
                return inputView.readGameCommand();
            }
            catch(Exception e){
                checkInputLimit(cnt);
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean retryGame() throws CloneNotSupportedException {
        String retryFlag = inputRetryFlag();

        return bridgeGame.retry(retryFlag);
    }
}
