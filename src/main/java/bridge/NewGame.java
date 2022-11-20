package bridge;

public class NewGame {

    private final BridgeGame bridgeGame;

    public NewGame(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void startNewGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int tryCount = 0;
        routine(tryCount);
    }

    private void routine(int tryCount) {
        String gameResult ="F";
        while (true){
            tryCount += 1;
            gameResult = bridgeGame.play();
            if (!gameResult.equals("R")) {break;}
        }
        printResult(tryCount,gameResult);
    }

    private void printResult(int tryCount, String gameResult){
        System.out.println("최종 게임 결과");
        bridgeGame.finish(gameResult,tryCount);
    }
}
