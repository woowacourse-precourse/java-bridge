package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String PRINT_GAME_START = "다리 건너기 게임을 시작합니다.";
    private final InputView INPUT_VIEW;
    private final OutputView OUTPUT_VIEW;
    private final BridgeRandomNumberGenerator BRIDGE_RANDOM_NUMBER_GENERATOR;
    private final BridgeMaker BRIDGE_MAKER;
    private int bridgeSize;
    private int tryCount;
    private boolean done;
    private List<String> bridge;

    public BridgeGame() {
        this.INPUT_VIEW = new InputView();
        this.OUTPUT_VIEW = new OutputView();
        this.BRIDGE_RANDOM_NUMBER_GENERATOR = new BridgeRandomNumberGenerator();
        this.BRIDGE_MAKER = new BridgeMaker(BRIDGE_RANDOM_NUMBER_GENERATOR);

        System.out.println(PRINT_GAME_START);
        this.bridgeSize = INPUT_VIEW.readBridgeSize();
        this.bridge = BRIDGE_MAKER.makeBridge(this.bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        String userInput = INPUT_VIEW.readMoving();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        return false;
    }

    public boolean isDone() {
        return this.done;
    }
}
