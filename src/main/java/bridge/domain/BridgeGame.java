package bridge.domain;

import bridge.View.InputView;
import bridge.View.OutputView;
import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    List<String> bridge = new ArrayList<>();
    int trial = 1;
    int position = 0;
    String lastMoving;

    public void start() {
        int size = inputView.readBridgeSize();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = bridgeMaker.makeBridge(size);
        //System.out.println(bridge);
        position = 0;
    }

    private void getMoving() {
        lastMoving = inputView.readMoving();
    }

    private boolean checkMoving(String moving) {
        return bridge.get(position - 1).equals(moving);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        getMoving();
        position++;
        boolean correct = checkMoving(lastMoving);
        outputView.printMap(bridge, position, correct, lastMoving);
        return correct;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String input = inputView.readGameCommand();
        boolean restart = false;
        if (input.equals("R")) {
            trial++;
            position = 0;
            restart = true;
        } else if (input.equals("Q")) {
            endGame(false);
            restart = false;
        }
        return restart;
    }

    public boolean gameSuccess() {
        return ((position == bridge.size()) && checkMoving(lastMoving));
    }

    public void endGame(boolean success) {
        outputView.printResult(bridge, position, success, trial);
    }
}
