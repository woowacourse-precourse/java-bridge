package bridge;

public class Application {
    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        BridgeGame bridgeGame = new BridgeGame();
        BridgeGameController.startGame(bridgeGame);
        boolean flag = true;
        while (flag) {
            while(BridgeGameController.moveGame(bridgeGame)){}
            flag = BridgeGameController.endOrRetry(bridgeGame);
        }
    }
}


