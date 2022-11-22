package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.gameStart();

        boolean run = true;
        while (run) {
            run = !bridgeGame.move();
            if (run == false) {       // 게임 실패시 재시도 여부
                run = bridgeGame.oneMore();
            }
            if (bridgeGame.checkEnd()) {
                bridgeGame.gameResult();
                run = false;
            }
        }
    }
}
