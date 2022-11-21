package bridge;

import bridge.io.InputView;
import bridge.io.Message;
import bridge.io.OutputView;
import bridge.utils.GameStatus;

import java.util.List;

public class BridgeProgram {
    private final InputView input;
    private final OutputView output;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;

    public BridgeProgram(InputView input, OutputView output, BridgeMaker bridgeMaker, BridgeGame bridgeGame) {
        this.input = input;
        this.output = output;
        this.bridgeMaker = bridgeMaker;
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        List<String> bridgeRoute = bridgeMaker.makeBridge(getBridgeSize());
        Bridge bridge = new Bridge(bridgeRoute);
        int movingCount = 0;

        while (GameStatus.isRunning) {
            Mark mark = bridge.matchRoute(getInputDirection(), movingCount++);
            List<List<String>> route = bridgeGame.move(mark);

            output.printMap(route);

            if (!mark.isRight()) {
                restartOrStop();
            }

            //if(다 맞춤) 결과출력
        }
    }

    private int getBridgeSize() {
        output.printMessage(Message.START);
        return input.readBridgeSize();
    }

    private String getInputDirection() {
        output.printMessage(Message.REQUEST_DIRECTION);
        return input.readMoving();
    }

    private void restartOrStop() {
        if (getGameCommand().equals("Q")) {
            GameStatus.quitGame();
            return;
        }
        bridgeGame.retry();
    }

    private String getGameCommand() {
        output.printMessage(Message.RESTART_OR_EXIT);
        return input.readGameCommand();
    }
}
