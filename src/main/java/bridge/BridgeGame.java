package bridge;

import java.util.List;
import java.util.ArrayList;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    List<String> bridge;
    List<String> trace;
    int rerun = 1;
    public BridgeGame(){}

    public void run(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeSize = InputView.readBridgeSize();
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
        String repeat = "";
        boolean result = move(bridgeSize);
        if (!result)
            result = retry(bridgeSize);
        OutputView.printResult(trace, result, rerun);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int bridgeSize) {
        trace = new ArrayList<>(bridgeSize);
        String updown;
        for (int step = 0; step < bridgeSize; step++) {
            trace.add((updown = InputView.readMoving()));
            if(!moveCheck(updown, step)){
                OutputView.printMap(trace, false); return false;
            }
            OutputView.printMap(trace, true);
        }
        return true;
    }


    public boolean moveCheck(String updown, int step) {
        if (updown.equals(bridge.get(step)))
            return true;
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(int bridgeSize) {
        String repeat = "";
        boolean result = false;
        while ((repeat = InputView.readGameCommand()).equals("R")){
            rerun++;
            result = move(bridgeSize);
            if (result)
                break;
        }
        return result;
    }
}
