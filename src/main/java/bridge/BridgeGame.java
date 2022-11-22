package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private int position;
    private InputView inputView;
    private OutputView outputView;
    private int tryCnt;


    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.position = 0;
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.tryCnt = 1;

    }

    public void start() {
        this.position = 0;

        while (!isSuccessGame()) {
            move();
        }
        exit();

    }

    private boolean isSuccessGame() {

        return position == bridge.size();

    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        String moving = inputView.readMoving();
        boolean isPass = isPassBridge(moving);
        outputView.printMap(bridge, position, isPass);
        if (!isPassBridge(moving)) {
            notPassGame();
            return;
        }
        passGame();

    }

    private boolean isPassBridge(String moving) {
        return bridge.get(position).equals(moving);
    }

    private void passGame() {
        position++;
    }

    private void notPassGame() {

        String input = inputView.readGameCommand();
        if (input.equals("R")) {
            retry();
            return;
        }
        if (input.equals("Q")) {
            exit();
            return;
        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCnt++;
        this.start();
    }

    public void exit() {

    }
}
