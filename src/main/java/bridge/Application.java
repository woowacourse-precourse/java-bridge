package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
            BridgeGame bridgeGame = new BridgeGame(bridge, new Player());
            System.out.println("다리 건너기 게임을 시작합니다.");
            while (true) {
                playGame(bridgeGame);
                if (bridgeGame.hasSucceeded()) {
                    break;
                }
                if (!bridgeGame.retry(InputView.readGameCommand())) { // 중간에 실패한 경우
                    break;
                }
                bridgeGame.setPlayer(new Player());
            }
            OutputView.printResult(bridgeGame);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void playGame(BridgeGame bridgeGame) {
        int totalRounds = bridgeGame.getTotalRounds();
        for (int round = 0; round < totalRounds; round++) {
            boolean isAnswer = bridgeGame.move(InputView.readMoving(), round);
            // moving 결과 출력
            OutputView.printMap(bridgeGame.getMap());
            if (!isAnswer) {
                return;
            }
        }
    }
}
