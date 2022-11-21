package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * 해당 클래스에서 InputView, OutputView를 사용하지 않는다.
 * 필드(인스턴스 변수)를 추가할 수 있다.
 * 메서드의 이름은 변경할 수 없고, 인자와 반환타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 게임 진행을 위한 메서드를 추가할 수 있다.
 */
public class BridgeGame {
    private int tryCount = 1;
    private List<String> movingStack;
    private List<String> bridge;

    BridgeGame(List<String> bridge) {
        movingStack = new ArrayList<>();
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving) {
        movingStack.add(moving);
        int index = movingStack.size() - 1;
        if (moving.equals(bridge.get(index))) {
            return true;
        }
        return false;
    }

    public void retry() {
        tryCount++;
        movingStack = new ArrayList<>();
    }

    public boolean isFinished() {
        if (movingStack.size() != bridge.size()) {
            return false;
        }
        for (int i = 0; i < bridge.size(); i++) {
            if (!movingStack.get(i).equals(bridge.get(i))) {
                return false;
            }
        }
        return true;
    }

    public String getGameResult() {
        if (isFinished()) {
            return "성공";
        }
        return "실패";
    }

    public List<String> getMap(MovingEnum movingEnum) {
        List<String> map = new ArrayList<>();
        for (int i = 0; i < movingStack.size(); i++) {
            String moving = movingStack.get(i);
            if (moving.equals(movingEnum.name())) {
                map.add(compareResult(moving, bridge.get(i)));
                continue;
            }
            map.add(" ");
        }
        return map;
    }

    private String compareResult(String moving, String curBridge) {
        if (moving.equals(curBridge)) {
            return "O";
        }
        return "X";
    }

    public int getTryCount() {
        return tryCount;
    }
}
