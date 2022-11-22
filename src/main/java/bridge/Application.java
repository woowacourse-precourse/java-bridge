package bridge;

import bridge.bridgeGame.BridgeGame;
import bridge.bridgeGame.BridgeGameLog;
import bridge.inputView.InputView;
import bridge.outputView.OutputView;
import java.util.List;

public class Application {
    private final static InputView readView = new InputView();
    private final static OutputView writeView = new OutputView();

    public static void main(String[] args) {
        OutputView.println("다리 건너기 게임을 시작합니다.");
        BridgeGame game = makeGame();
        BridgeGameLog log = new BridgeGameLog();
        playGame(game, log);
        writeView.printResult(game, log);
    }

    private static BridgeGame makeGame() {
        final int bridgeSize = readView.readBridgeSize();
        final BridgeNumberGenerator bridgeNumberMaker = new BridgeRandomNumberGenerator();
        final List<String> bridges = new BridgeMaker(bridgeNumberMaker).makeBridge(bridgeSize);
        return new BridgeGame(bridges);
    }

    private static void playGame(BridgeGame game, BridgeGameLog log) {
        while (game.isGameNotEnd()) {
            final String command = readView.readMoving();
            log.addLog(game.isMove(command), command);
            game.retry(command, () -> readView.readGameCommand());
            game.move(command);
            writeView.printMap(log);
        }
    }
}
