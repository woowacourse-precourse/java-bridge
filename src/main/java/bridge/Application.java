package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int count = 1;
        System.out.println("다리 건너기 게임을 시작합니다.");

        BridgeGame bridgeGame = new BridgeGame();
        int size = bridgeGame.inputView.readBridgeSize();
        List<String> bridge = bridgeGame.bridgeMaker.makeBridge(size);
        List<String> states = new ArrayList<>();
        boolean next = true;
        String gameCommand = "R";

        while (next) {
            String moving = bridgeGame.inputView.readMoving();
            try {
                next = bridgeGame.move(moving, bridge, states);
                bridgeGame.outputView.printMap(bridge, states);
            } catch (IllegalStateException e) {
                bridgeGame.outputView.printMap(bridge, states);
                gameCommand = bridgeGame.inputView.readGameCommand();
                if (gameCommand.equals("Q")) {
                    break;
                }
                states.clear();
                count++;
            }
        }
        bridgeGame.outputView.printResult(bridge, states, gameCommand, count);
    }
    }
}
