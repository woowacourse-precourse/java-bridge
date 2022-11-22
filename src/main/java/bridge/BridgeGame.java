package bridge;

import static bridge.Bridge.CANNOT_CROSS_NEXT;
import static bridge.Bridge.JUST_CROSSED;
import static bridge.Bridge.JUST_CROSSED_AND_CROSS_OVER;
import static constant.Message.*;

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
        int result = move();

        while (result == JUST_CROSSED) {
            outputView.printMap(bridge.movingResultToString(SUCCESS));
            result = move();
        }
        if (result == JUST_CROSSED_AND_CROSS_OVER) {
            outputView.printResult(bridge, SUCCESS);
        }
        retry(result);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int move() {
        return bridge.moveAndReturnMovingResult(
                inputView.readMoving()
        );
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(int result) {
        if (result == CANNOT_CROSS_NEXT) {
            outputView.printMap(bridge.movingResultToString(FAILURE));
            if (inputView.readGameCommand().equals(REGAME)) {
                resetAndRegame();
                return;
            }
            outputView.printResult(bridge, FAILURE);
        }
    }

    public void resetAndRegame() {
        bridge.reset();
        start();
    }
}
