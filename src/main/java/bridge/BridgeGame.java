package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int tryTimes = 0;
    private int nowIndex = 0;
    private final List<String> answer;

    public BridgeGame(List<String> answer) {
        this.answer = answer;
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving) {
        if(moving == answer.get(nowIndex)) {
            nowIndex++;
        }
        PrintBridge printBridge = new PrintBridge();
        printBridge.printBridgeMoveResult(answer, ++nowIndex);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        nowIndex = 0;
    }

    public int getTryTimes() {
        return tryTimes;
    }

    public void addTryTimes() {
        tryTimes++;
    }

    public int getNowIndex() {
        return nowIndex;
    }

    public void addNowIndex() {
        nowIndex++;
    }
}
