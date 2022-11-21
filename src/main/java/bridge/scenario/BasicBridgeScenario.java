package bridge.scenario;

import static bridge.game.BridgeGameStatus.*;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.game.BridgeGame;
import bridge.game.BridgeGameStatus;
import bridge.view.input.InputView;
import bridge.view.output.OutputView;
import java.util.Arrays;
import java.util.List;

public class BasicBridgeScenario implements BridgeScenario {
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());


    @Override
    public void play() {
        output.printStart();

        BridgeGame game = retryableReadSizeAndInitGame();

        loopTurn(game);

        endGame(game);
    }

    private BridgeGame retryableReadSizeAndInitGame() {
        try {
            int size = input.readBridgeSize();
            List<String> answer = bridgeMaker.makeBridge(size);
            return new BridgeGame(answer);
        } catch (IllegalArgumentException e) {
            output.printException(e);
            return retryableReadSizeAndInitGame();
        }
    }

    private void loopTurn(BridgeGame game) {
        while (!game.status().equals(FINISH)) {
            if (game.status().equals(RUNNING)) {
                retryableMove(game);
            }
            if (game.status().equals(STOP) && askEndGame(game)) {
                break;
            }
        }
    }

    private void retryableMove(BridgeGame game) {
        try {
            move(game);
        } catch (IllegalArgumentException e) {
            output.printException(e);
            retryableMove(game);
        }
    }

    private void move(BridgeGame game) {
        String command = input.readMoving();

        game.move(command);

        List<List<String>> progress = game.progressMap();
        output.printMap(progress);
    }

    private boolean askEndGame(BridgeGame game) {
        String command = input.readGameCommand();
        if (command.equals("Q")) {
            return true;
        }
        if (!command.equals("R")) {
            throw new IllegalArgumentException("[ERROR]~~");
        }
        game.retry();
        return false;
    }

    private void endGame(BridgeGame game) {
        output.printAnswer(game.answerMap());
        output.printResult(game.status().text(), game.tryTimes());
    }
}
