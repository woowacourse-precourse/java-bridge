package bridge;

import java.util.List;
import java.util.Stack;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * Controller라고 할 수 있다.
 */
public class BridgeGame {
    public int idx;

    public BridgeGame() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        Model.size = new InputView().readBridgeSize();
        new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(Model.size); // 다리 생성
        run();
    }

    public void run() {
        Model.user = new Stack<>();
        this.idx = 0;
        do {
            move();
        } while (runCondition(Model.user, Model.bridge));
        if (idx == Model.size) { // 다리를 다 지나간 상태라면
            new OutputView().printResult(); // 결과 출력
            return;
        }
        retry();
    }

    public void move() {
        Model.user.add(new InputView().readMoving());
    }

    public boolean runCondition(Stack<String> user, List<String> bridge) {
        if (user.peek().equals(bridge.get(idx))) {
            this.idx++;
            // 다리 크기 만큼 다 지나갔다면
            return idx < Model.size;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        new InputView().readGameCommand();
    }


}
