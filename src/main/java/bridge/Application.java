package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    private static final String START_BRIDGE_GAME = "다리 건너기 게임을 시작합니다.\n";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        BridgeGame bridgeGame = createBridgeGame(inputView);
        while (!bridgeGame.endGame()) {
            if (inputMoving(inputView, outputView, bridgeGame)) continue;
            if (inputRetry(inputView, bridgeGame)) break;
        }
        System.out.println(outputView.printResult(bridgeGame.currentBridge(), bridgeGame.getNumberOfTry()));
    }

    private static boolean inputRetry(InputView inputView, BridgeGame bridgeGame) {
        return !bridgeGame.retry(inputView.readGameCommand());
    }

    private static boolean inputMoving(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        if (bridgeGame.move(inputView.readMoving())) {
            System.out.println(outputView.printMap(bridgeGame.currentBridge()));
            return true;
        }
        System.out.println(outputView.printMap(bridgeGame.currentBridge()));
        return false;
    }

    private static BridgeGame createBridgeGame(InputView inputView) {
        System.out.println(START_BRIDGE_GAME);
        return new BridgeGame(new BridgeMaker(new BridgeRandomNumberGenerator())
                .makeBridge(inputView.readBridgeSize()));
    }

}
