package bridge;

public class Application {

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        BridgeGame bridgeGame = new BridgeGame();
        startGame(bridgeGame);
        boolean flag = true;
        while (flag) {
            while(moveGame(bridgeGame)){}
            flag = endOrRetry(bridgeGame);
        }
    }

    public static void startGame(BridgeGame bridgeGame){
        boolean flag ;
        do {
            try {
                flag = false;
                int bridgeSize = InputView.readBridgeSize();
                bridgeGame.setSize(bridgeSize);
            } catch (IllegalArgumentException e) {
                flag = true;
            }
        } while (flag);
    }

    public static boolean moveGame(BridgeGame bridgeGame){
        boolean flag;
        do {
            try {
                flag = false;
                return moveGame1(bridgeGame);
            } catch (IllegalArgumentException e) {
                flag = true;
            }
        } while (flag);
        return false;
    }

    public static boolean moveGame1(BridgeGame bridgeGame){
        String userMove = InputView.readMoving();
        OutputView.printMap(bridgeGame.getBridge(), bridgeGame.getNowIdx(), userMove);
        return bridgeGame.move(userMove);
    }

    public static boolean retryGame(BridgeGame bridgeGame){
        boolean flag;
        do {
            try {
                flag = false;
                return bridgeGame.retry(InputView.readGameCommand());
            } catch (IllegalArgumentException e) {
                flag = true;
            }
        } while (flag);
        return false;
    }

    public static boolean endGame(BridgeGame bridgeGame){
        OutputView.printResult(bridgeGame);
        return false;
    }

    public static boolean endOrRetry(BridgeGame bridgeGame){
        boolean flag;
        do {
            try {
                flag = false;
                return endOrRetry1(bridgeGame);
            } catch (IllegalArgumentException e) {flag = true;}
        } while (flag);
        return true;
    }

    public static boolean endOrRetry1(BridgeGame bridgeGame){
        if(bridgeGame.getWin())
            return endGame(bridgeGame);
        if(retryGame(bridgeGame) == false)
            return endGame(bridgeGame);
        return true;
    }

}


