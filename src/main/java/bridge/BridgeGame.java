package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridgeState = new ArrayList<>();

    private BridgeMaker bridgeMaker;
    private Bridge bridge;
    private int tryCount = 1;

    public void play() {
        bridge = new Bridge();
        while(!bridge.checkResult()) {
            if(move(InputView.readMoving())) {
                OutputView.printMap(bridgeState);
                continue;
            }
            OutputView.printMap(bridgeState);
            if(retry().equals("Q")) {
                break;
            }
            removeBridgeState();
            bridge.incorrect();
            addTryCount();
        }

    }

    private void addTryCount() {
        this.tryCount++;
    }

    private void removeBridgeState() {
        if(!bridgeState.isEmpty()) {
            bridgeState.remove(bridgeState.size()-1);
        }
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String uOrD) {
        if(!bridge.matchBridge(uOrD)) {
            bridgeState.add(uOrD + "X");
            return false;
        }
        bridgeState.add(uOrD + "O");
        return true;
    }

    public List<String> move(Bridge b, String uOrD) {
        if(!b.matchBridge(uOrD)) {
            bridgeState.add(uOrD + "X");
        } else{
            bridgeState.add(uOrD + "O");
        }
        return bridgeState;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String retry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String rOrQ = Console.readLine();
        return rOrQ;
    }
}
