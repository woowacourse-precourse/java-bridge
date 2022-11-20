package bridge;

import java.util.List;
import java.util.Stack;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * Controller라고 할 수 있다.
 */
public class BridgeGame {
    public int idx;
    public int runCount=0;

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
            // 이곳에 중간 상태 메시지 작성
            // 모델의 정보를 먼저 수정해준 뒤 뷰를 호출하여 출력하여야 한다.
            new VisualizeController();
            new OutputView().printMap();
        } while (runCondition(Model.user, Model.bridge));
        runCount++;
        if (idx == Model.size) { // 다리를 다 올바르게 지나간 상태라면
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
            return idx < Model.size;
        }
        return false;
    }

    public void retry() { // 인스턴스 변수들을 다시 초기화 시켜주어야 한다.
        if (new InputView().readGameCommand().equals("Q")) {
            new OutputView().printResult();
            return;
        }
        run();
    }
}
