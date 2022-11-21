package bridge.Model;

import bridge.*;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;
import java.util.Stack;
/**
 * View 코드를 사용하지 말라는 것으로 보아 Model 이다.
 * 따라서 리팩토링이 필요하다.
 * 그렇다면 게임 진행에 필요한 데이터를 저장하고 수정하는 공간으로 만들어야 한다.
 * **/
public class BridgeGame {
    public int idx;
    public int runCount=1;
    public static List<String> bridge;
    public static Stack<String> user = new Stack<>();
    public static String upperResult = "[]";
    public static String lowerResult = "[]";

    public static int size;
    public BridgeGame() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        size = new InputView().readBridgeSize();
        new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(BridgeGame.size);
        run(runCount);
        lowerResult="[]";
        upperResult="[]";
    }

    public void run(int runCount) {
        user = new Stack<>();
        this.idx = 0;
        do {
            move();
            new VisualizeController(idx);
            new OutputView().printMap();
        } while (runCondition(user, bridge));
        if (idx == size) {
            new OutputView().printResult(true,runCount);
            return;
        }
        retry();
    }

    public void move() {
        user.add(new InputView().readMoving());
    }

    public boolean runCondition(Stack<String> user, List<String> bridge) {
        if (user.peek().equals(bridge.get(idx))) {
            this.idx++;
            return idx < size;
        }
        return false;
    }

    public void retry() {
        if (new InputView().readGameCommand().equals("Q")) {
            new OutputView().printResult(false,runCount);
            lowerResult="[]";
            upperResult="[]";
            return;
        }
        lowerResult="[]";
        upperResult="[]";
        runCount++;
        run(runCount);
    }
}
