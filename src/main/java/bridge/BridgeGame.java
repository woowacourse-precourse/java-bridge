package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private BridgeMaker bridgeMaker;

    private GameSimulation gameSimulation;
    private List<String> bridge;
    private static final String SUCCESS = "O";
    private static final String FAIL = "X";
    private static final String RESULT_SUCCESS = "성공";
    private static final String RESULT_FAIL = "실패";
    private static final String RETRY = "R";

    public BridgeGame() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void generateBridge(int size) {
        bridge = bridgeMaker.makeBridge(size);
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String direction) {
        int location = gameSimulation.getLocation();
        String compare = compare(direction, bridge.get(location));
        gameSimulation.print(direction, compare);
        if (compare.equals(SUCCESS)) {
            gameSimulation.addLocation();
        }
        checkMove();
        return compare;
    }


    private void checkMove() {
        if (gameSimulation.getLocation() == bridge.size()) {
            gameSimulation.setSuccess(RESULT_SUCCESS);
        }
    }

    public boolean success() {
        if (gameSimulation.getSuccess().equals(RESULT_SUCCESS)) {
            return true;
        }
        return false;
    }

    public boolean fail(String match) {
        if (success()) {
            return false;
        }
        if (match.equals(FAIL)) {
            return false;
        }
        return true;
    }

    private String compare(String user, String answer) {
        if (!user.equals(answer)) {
            return FAIL;
        }
        return SUCCESS;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        if (!gameSimulation.getSuccess().equals(RESULT_FAIL) && command.equals(RETRY)) {
            return true;
        }
        return false;
    }

    public void newGameSimulation() {
        gameSimulation = new GameSimulation();
    }

    public GameSimulation getGameSimulation() {
        return gameSimulation;
    }
}
