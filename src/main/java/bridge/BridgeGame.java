package bridge;

import static bridge.Bridge.JUST_CROSSED;
import static bridge.Bridge.JUST_CROSSED_AND_CROSS_OVER;
import static constant.Message.*;

import constant.Message;
import view.InputView;
import view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = new Bridge(maker.makeBridge(inputView.readBridgeSize()));
    }

    public void start() {
        int result = 0;

        do {
            result = move();
            if (result == JUST_CROSSED) {
                outputView.printMap(bridge.movingResultToString(SUCCESS));
                continue;
            }
            break;
        } while (true);

        if (result == JUST_CROSSED_AND_CROSS_OVER) {
            outputView.printResult(bridge, SUCCESS);
            return;
        }
        outputView.printMap(bridge.movingResultToString(FAILURE));
        retry();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int move() {
        return bridge.updateMovingResultAndReturnNextMovingPossible(
                inputView.readMoving()
        );
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals(REGAME)) {
            bridge.reset();
            start();
            return;
        }
        outputView.printResult(bridge, FAILURE);
    }
}
