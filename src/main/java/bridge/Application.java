package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(InputView.readBridgeSize()));
            Player player = new Player();
            System.out.println("다리 건너기 게임을 시작합니다.");
            while (!bridgeGame.isSucceeds()) {
                playGame(bridgeGame, player);
                if (bridgeGame.isSucceeds()) {
                    break;
                }
                if (!bridgeGame.retry(InputView.readGameCommand())) { // 중간에 실패한 경우
                    break;
                }
                player = new Player();
            }
            OutputView.printResult(player.generateMap(), bridgeGame);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void playGame(BridgeGame bridgeGame, Player player) {
        int totalRounds = bridgeGame.getTotalRounds();
        for (int round = 0; round < totalRounds; round++) {
            boolean isAnswer = bridgeGame.move(player, InputView.readMoving());
            // moving 결과 출력
            OutputView.printMap(player.generateMap());
            if (!isAnswer) {
                return;
            }
        }
        bridgeGame.makeSuccess();
    }
}
