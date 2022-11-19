package bridge;

import bridge.models.BridgeGame;
import bridge.views.OutputView;

public class Application {
    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        BridgeGame bridgeGame = Controller.makeBridgeMap();
        OutputView outputView;
        do {
            outputView = new OutputView();
            Controller.startRound(bridgeGame, outputView);
            if (bridgeGame.gameSuccess()) {
                break;
            }
            Controller.restartGame(bridgeGame);
        } while (bridgeGame.isGameContinue());
        outputView.printResult(bridgeGame);
    }
}
