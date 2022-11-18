package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputView;
import bridge.OutputView;
import bridge.domain.Player;
import java.util.List;

public class BridgeGameController {

    public void run() {
        OutputView.printGameStart();
        int bridgeSize = InputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        Player player = new Player();
        playGame(bridgeGame, player);
    }

    private void playGame(BridgeGame bridgeGame, Player player) {
        System.out.println(bridgeGame.getBridge());
        while (!bridgeGame.isGameEnd(player.get())) {
            String playerMove = InputView.readMoving();
            player.addMove(playerMove);
            if (bridgeGame.isMovable(player.get(), player.getPosition())) {
                OutputView.printMap(bridgeGame.getBridge(), player);
                player.move();

                continue;
            }
            if (!bridgeGame.isMovable(player.get(), player.getPosition())) {
                OutputView.printMap(bridgeGame.getBridge(), player);
                player.move();
                String choice = InputView.readGameCommand();
                if (choice.equals("R")) {
                    Player newPlayer = new Player();
                    bridgeGame.addTrialCount();
                    playGame(bridgeGame, newPlayer);
                }
                break;
            }
        }
        endGame(bridgeGame, player);
    }

    private void endGame(BridgeGame bridgeGame, Player player) {
        OutputView.printResult(bridgeGame.getBridge(), player);
        if (bridgeGame.isGameEnd(player.get())) {
            System.out.println("게임 성공 여부: 성공");
        } else {
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: " + bridgeGame.getTrialCount());
    }

}
