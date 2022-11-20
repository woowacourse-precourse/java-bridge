package bridge;

import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public final String STARTGAME = "다리 건너기 게임을 시작합니다.";

    public InputView inputView;
    public OutputView outputView;
    public BridgeMaker bridgeMaker;

    public List<String> bridge;
    public int userLocation = 0;

    public BridgeGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void game() {
        System.out.println(STARTGAME+'\n');

        int bridgeSize = inputView.readBridgeSize();
        this.bridge  = bridgeMaker.makeBridge(bridgeSize);

        String moving = inputView.readMoving();
        move(moving);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        if (canMove(moving)) {
            userLocation++;
        } else {
            retry();
        }
    }

    private boolean canMove(String moving) {
        if (bridge.get(userLocation) == moving) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
