package bridge;

import bridge.bridgeGame.BridgeGame;
import bridge.inputView.InputView;
import bridge.outputView.OutputView;
import java.util.List;

public class Application {
    private final static InputView readView = new InputView();
    private final static OutputView writeView = new OutputView();

    public static void main(String[] args) {
        OutputView.println("다리 건너기 게임을 시작합니다.");
        BridgeGame game = makeGame();
        playGame(game);
        writeView.printResult(game);
    }

    private static BridgeGame makeGame() {
        final int bridgeSize = readView.readBridgeSize();
        final BridgeNumberGenerator bridgeNumberMaker = new BridgeRandomNumberGenerator();
        final List<String> bridges = new BridgeMaker(bridgeNumberMaker).makeBridge(bridgeSize);
        return new BridgeGame(bridges);
    }

    private static void playGame(BridgeGame game) {
        while (game.isGameEnd()) {
            final String command = readView.readMoving();
            game.addLog(command);
            game.retry(command, () -> readView.readGameCommand());
            game.move(command);
            writeView.printMap(game);
        }
    }
}
