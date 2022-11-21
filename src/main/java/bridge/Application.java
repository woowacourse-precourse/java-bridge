package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("다리 건너기 게임을 시작합니다.");
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.init();
        gameStart(bridgeGame);
    }
    private static void gameStart(BridgeGame bridgeGame) {
        while(true) {
            boolean move = bridgeGame.move();
            if(bridgeGame.isGameCompleted()) {
                break;
            }
            if(!move && !bridgeGame.retry()) {
                break;
            }
        }
    }
}
