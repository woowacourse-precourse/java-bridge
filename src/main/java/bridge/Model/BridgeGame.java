package bridge.Model;

import bridge.Controller.GameController;
import bridge.View.InputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String PASS_CASE = "O";
    private static final String FAIL_CASE = "X";

    private final InputView inputView;
    private final GameController gameController;

    public BridgeGame() {
        this.inputView = new InputView();
        this.gameController = new GameController();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return 해당 움직임의 성공/ 실패를 전달한다.
     */
    public String move(String bridgeShape, String nextMove) {
        if(bridgeShape.matches(nextMove))
            return PASS_CASE;
        return FAIL_CASE;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        String inputCommand = inputView.readGameCommand();
        gameController.checkKeepGoing(inputCommand);
    }
}
