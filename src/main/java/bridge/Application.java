package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        BridgeGame bridgeGame = new BridgeGame(InputView.readBridgeSize());

        OutputView.printResult(bridgeGame.isEnd(), bridgeGame.getGameTryCount());
    }
}
