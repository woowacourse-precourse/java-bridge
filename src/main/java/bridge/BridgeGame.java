package bridge;

import java.util.List;

import static bridge.Enums.StringValue.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeOutput bridgeOutput = new BridgeOutput();
    private String res = SUCCESS.getValue();
    private Bridge arrangedBridge;
    private int tryCount = 1;

    public void play(List<String> bridge) {
        this.arrangedBridge = new Bridge(bridge);
        playAndPrint();
        bridgeOutput.printResult(arrangedBridge, tryCount, res);
    }

    private void playAndPrint() {
        while(!arrangedBridge.checkResult()) {
            if(moveAndPrint()) {
                continue;
            }
            if(!retry(arrangedBridge.inputGameCommand())) {
                break;
            }
        }
    }

    private boolean moveAndPrint() {
        boolean flag = move(arrangedBridge.inputMoving());
        bridgeOutput.printMap(arrangedBridge, flag);
        return flag;
    }

    private void addTryCount() {
        this.tryCount++;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private boolean move(final String uOrD) {
        if(!arrangedBridge.matchBridge(uOrD)) {
            return false;
        }
        arrangedBridge.increasePos();
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private boolean retry(String retryOrNot) {
        if(QUIT.isEqual(retryOrNot)){
            res = FAIL.getValue();
            return false;
        }
        addTryCount();
        return true;
    }
}
