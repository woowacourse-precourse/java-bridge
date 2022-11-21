package bridge;

import java.util.List;

public class Application {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeGame bridgeGame = new BridgeGame();
    String game = "R";
    int count = 1;

    public void run() {
        // output view
        outputView.startMessage();
        // 자동으로 생성할 다리 길이를 입력 받는다. --> input view
        int bridgeSize = getBridgeSize();
        // 다리를 생성합니다. --> bridge maker
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        // U 또는 D 입력 받기 --> input view
        crossingTheBridge(bridgeSize, bridge);
    }

    private int getBridgeSize() {
        int bridgeSize = 0;
        while (bridgeSize == 0) {
            bridgeSize = inputView.readBridgeSize();
        }
        return bridgeSize;
    }

    private void crossingTheBridge(int bridgeSize, List<String> bridge) {
        while (game.equals("R")) {
            // 이동할 칸을 선택해주세요 --> output view
            String move = inputView.getMove();
            // 다리를 출력합니다 --> output view
            bridgeGame.move(bridge, move);
            if (bridge.size() > bridgeSize) {
                // 게임 실패시 다시 시도 여부 --> bridge game, output view
                game = inputView.readGameCommand();
                // R 또는 Q 입력 --> input view
                restartAfterFailure(bridge);
                outputView.endAfterFailure(bridgeGame, game, count);
            }
            // 마지막 칸 도착시,최종 게임 결과
            // 다리 출력, 게임 성공 여부 출력,시도 횟수 출력
            game = outputView.printResult(bridgeGame, bridgeSize, count, game);
        }
    }

    private void restartAfterFailure(List<String> bridge) {
        if (game.equals("R")) {
            bridgeGame.retry(bridge);
            count++;
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application app = new Application();
        app.run();

    }
}
