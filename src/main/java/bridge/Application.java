package bridge;

public class Application {

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        BridgeGame bridgeGame = new BridgeGame();
        startGame(bridgeGame);
        while(moveGame(bridgeGame)){
            if(!retryGame(bridgeGame))
                break;
        }
        endGame(bridgeGame);
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
        boolean continueGame = true;
        boolean bridgeStatus = true;
        while (continueGame) {
            while (bridgeStatus) {
                String userMove = InputView.readMoving();
                bridgeStatus = bridgeGame.move(userMove);
                OutputView.printMap(bridgeGame.getBridge(), bridgeGame.getNowIdx(), userMove);
            }
        }
    }

    public static boolean retryGame(BridgeGame bridgeGame){}
    public static void endGame(BridgeGame bridgeGame){

    }

}
