package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private InputView inputView;
    private OutputView outputView;

    /**
     * 게임 관리 컨트롤러에서 필요한 객체를 생성해 주입한다.
     */
    public BridgeGame() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    /**
     * 게임을 시작하는 메서드
     */
    public void run() {
        outputView.printStart();

        int bridgeSize = inputView.readBridgeSize();

    }
    
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
}
