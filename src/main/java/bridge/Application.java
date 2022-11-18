package bridge;

public class Application {
    static BridgeGame startGame() {
        System.out.println("다리 건너기 게임을 시작합니다\n");
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(new BridgeRandomNumberGenerator()));

        int bridgeSize = InputView.readBridgeSize();
        bridgeGame.initializeBridgeGame(bridgeSize);

        return bridgeGame;
    }

    static void playGame(BridgeGame bridgeGame) {
        while (!bridgeGame.terminateCheck()) {
            if (getUserStep(bridgeGame)) continue;
            if (InputView.readGameCommand().equals("Q")) break;
            bridgeGame.retry();
        }
    }

    static void terminateGame(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        OutputView.printMap(bridgeGame);
        OutputView.printResult(bridgeGame);
    }

    static boolean getUserStep(BridgeGame bridgeGame) {
        String stepInput = InputView.readMoving();
        boolean stepCheck = bridgeGame.move(stepInput);
        OutputView.printMap(bridgeGame);
        return stepCheck;
    }

    public static void main(String[] args) {
        BridgeGame bridgeGame = startGame();
        playGame(bridgeGame);
        terminateGame(bridgeGame);
    }
}
