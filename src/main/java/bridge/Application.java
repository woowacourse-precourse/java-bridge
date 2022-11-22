package bridge;

public class Application {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        System.out.println("다리 건너기 게임을 시작합니다.");
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(InputView.readBridgeSize()));
        bridgeGame.checkMovable(InputView.readMoving());
    }
}
