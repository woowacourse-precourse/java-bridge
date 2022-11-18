package bridge;

import bridge.io.InputView;
import bridge.io.Message;
import bridge.io.OutputView;

import java.util.LinkedList;
import java.util.List;

public class BridgeProgram {
    private final List<String> route;
    private final InputView input;
    private final OutputView output;
    private final BridgeMaker bridgeMaker;

    public BridgeProgram(InputView input, OutputView output, BridgeMaker bridgeMaker) {
        this.route = new LinkedList<>();
        this.input = input;
        this.output = output;
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        List<String> bridge = bridgeMaker.makeBridge(getBridgeSize());

        boolean isRunning = true;
        while (isRunning) {
            String inputDirection = getInputDirection();

            //route 출력

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
