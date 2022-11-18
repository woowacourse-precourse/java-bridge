package bridge;

import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public List<String> initBridge(int size) {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> gameBridge = bridgeMaker.makeBridge(size);

        return gameBridge;
    }

    /**
     * 아래 코드는 임시 흐름 코드
     * skeleton code
     */
    public void start() {
        InputView inputModule = new InputView();
        OutputView outputModule = new OutputView();

        outputModule.printGameStartMessage();

        outputModule.printBridgeSizeRequestMessage();
        inputModule.readBridgeSize();

        while (true) {
            move();
            outputModule.printMap();

            if (1 == 1) {
                break;
            }
        }

        outputModule.printResult();
    }
}
