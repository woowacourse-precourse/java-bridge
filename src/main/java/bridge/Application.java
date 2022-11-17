package bridge;

import bridge.domain.BridgeGame;
import bridge.io.InputView;
import bridge.io.OutputView;

public class Application {

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        int bridgeSize = InputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame game = new BridgeGame(bridgeMaker.makeBridge(bridgeSize));
        while (!game.isEnd()) {
            game.move(InputView.readMoving());
            OutputView.printMap(game.getTopRoad(), game.getDownRoad());
            if (game.isStopped()) {
                if (InputView.readGameCommand().equals("Q"))
                    break;
                game.retry();
            }
        }
        OutputView.printResult(game.getTopRoad(), game.getDownRoad(),
                game.isEnd(), game.getNumOfAttempts());
    }
}
