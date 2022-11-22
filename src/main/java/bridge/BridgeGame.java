package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final String CORRECT = "O";
    private final String WRONG = "X";
    private final String NOTHING = " ";
    private final List<List<String>> bridgePattern = new ArrayList<>();
    private final List<String> correctBridge;

    public BridgeGame(List<String> correctBridge) {
        this.correctBridge = correctBridge;
        for (int i = 0; i < 2; i++)
            this.bridgePattern.add(new ArrayList<>());
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving, int bridgeNum) {
        int moveNum = toMovingNumber(moving);
        String answer = this.correctBridge.get(bridgeNum);
        this.bridgePattern.get(1 - moveNum).add(NOTHING);

        if (moving.equals(answer))
            this.bridgePattern.get(moveNum).add(CORRECT);
        if (!moving.equals(answer))
            this.bridgePattern.get(moveNum).add(WRONG);
    }

    private int toMovingNumber(String moving) {
        if (moving.equals("D"))
            return 1;
        return 0;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        newBridgePattern();
    }

    private void newBridgePattern() {
        this.bridgePattern.clear();
        for (int i = 0; i < 2; i++)
            this.bridgePattern.add(new ArrayList<>());
    }

    public List<List<String>> getBridgePattern() {
        return bridgePattern;
    }

}
