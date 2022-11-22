package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.Map;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
            BridgeGame bridgeGame = new BridgeGame(bridge, new Player(new Map()));
            System.out.println("다리 건너기 게임을 시작합니다.");
            playGame(bridgeGame);
            OutputView.printResult(bridgeGame);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void playGame(BridgeGame bridgeGame) {
        while (true) {
            playGameOnce(bridgeGame);
            if (bridgeGame.hasSucceeded()) {
                break;
            }
            if (!bridgeGame.retry(InputView.readGameCommand())) {
                break;
            }
            bridgeGame.setPlayer(new Player(new Map()));
        }
    }

    private static void playGameOnce(BridgeGame bridgeGame) {
        int totalRounds = bridgeGame.getTotalRounds();
        for (int round = 0; round < totalRounds; round++) {
            boolean isAnswer = bridgeGame.move(InputView.readMoving(), round);
            OutputView.printMap(bridgeGame.getMap());
            if (!isAnswer) {
                return;
            }
        }
    }
}
