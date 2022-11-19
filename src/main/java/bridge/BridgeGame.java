package bridge;

import view.InputView;
import view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    /**
     * 필드의 수가 많은데 InputView, OutputView의 함수를 static으로 정의할까?
     */


    private final Bridge bridge;
    /** 재사용해야하니까
     * private final로 인스턴스 변수로 선언했는데
     * 다른 방법으로 재사용하게끔 만들수있을까?
     */
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = new Bridge(maker.makeBridge(inputView.readBridgeSize()));
    }

    public void start() {

    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        inputView.readMoving();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
