package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final int MIN_BRIDGE_LEN = 3;
    private static final int MAX_BRIDGE_LEN = 20;
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RESTART = "R";
    private static final String QUIT = "Q";
    private List<String> visited = new ArrayList<>();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final Validate validate = new Validate();
    private Bridge bridge;
    private int tryNum = 1;
    private boolean isSuccess = true;

    public void init(String input) {
        validate.validateNumberRange(input, MIN_BRIDGE_LEN, MAX_BRIDGE_LEN);
        int bridgeLen = Integer.parseInt(input);
        List<String> answerBridge = bridgeMaker.makeBridge(bridgeLen);
        bridge = new Bridge(answerBridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction) {
        validate.validateContainWord(direction, UP, DOWN);
        visited.add(direction);
        return bridge.isRightDirection(visited.size()-1, direction);

    }

    public List<String> getUpBridge() {
        List<String> upBridge = new ArrayList<>();
        for (int i = 0; i < visited.size(); i++) {
            boolean rightDirection = bridge.isRightDirection(i, visited.get(i));
            String result = getResult(i, "U", rightDirection);
            upBridge.add(result);
        }
        return upBridge;
    }

    public List<String> getDownBridge() {
        List<String> downBridge = new ArrayList<>();
        for (int i = 0; i < visited.size(); i++) {
            boolean rightDirection = bridge.isRightDirection(i, visited.get(i));
            String result = getResult(i, "D", rightDirection);
            downBridge.add(result);
        }
        return downBridge;
    }
    public String getResult(int i, String direction, boolean rightDirection) {
        String result = "O";
        if (!rightDirection) {
            isSuccess = false;
            result = "X";
        }
        if (!visited.get(i).equals(direction)) {
            result = " ";
        }
        return result;
    }

    public boolean isGameCompleted() {
        if (bridge.isCrossedBridge(visited) && isSuccess) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String select) {
        validate.validateContainWord(select, RESTART, QUIT);
        if (select.equals("R")) {
            reStartInit();
            return true;
        }
        return false;
    }

    public void reStartInit() {
        visited = new ArrayList<>();
        tryNum += 1;
        isSuccess = true;
    }

    public int getTryNum() {
        return tryNum;
    }

    public String getGameResult() {
        String result = "실패";
        if (isGameCompleted()) {
            result = "성공";
        }
        return result;
    }
}
