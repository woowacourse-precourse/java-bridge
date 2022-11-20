package bridge;

import bridge.io.InputView;
import bridge.io.Message;
import bridge.io.OutputView;

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

        boolean isRunning = true;
        while (isRunning) {
            Mark mark = bridge.matchRoute(getInputDirection(), movingCount++);
            List<List<String>> route = bridgeGame.move(mark);

            output.printMap(route);

            //if(direction 틀림) 게임 종료여부 물어보기
            //종료선택 시 결과출력 + isRunning = false;
            //재시작 시 route reset

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
}
