package bridge;

public class newGame {

    public void startNewGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        BridgeGame bridgeGame = new BridgeGame();
        String gameResult = "F";
        int tryCount = 0;
        while (true){
            tryCount += 1;
            gameResult = bridgeGame.play();
            if (!gameResult.equals("R")) {
                break;
            }
        }
        bridgeGame.finish(gameResult,tryCount);
    }

}
