package bridge;

import java.util.List;

public class Application {

    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printMessage(GAME_START);
        InputView inputView = new InputView();
        int bridgeSize = inputView.getBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println("bridge = " + bridge);

        BridgeGame bridgeGame = new BridgeGame(bridge);
        int nowBridgeIndex = 0;
        int retryCount = 0; // 재시도 수
        while (nowBridgeIndex < bridgeSize) {
            boolean isMoved = bridgeGame.move(nowBridgeIndex, inputView.getMoving());
            if (isMoved) {
                nowBridgeIndex++;
            } else {
                retryCount++;
                boolean isRetry = bridgeGame.retry(inputView.getGameCommand());
                if (isRetry) {
                    nowBridgeIndex = 0;
                } else {
                    break;
                }
            }
        }
        bridgeGame.end(nowBridgeIndex, retryCount);
    }

}
