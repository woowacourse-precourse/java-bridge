package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private BridgeMaker bridgeMaker;

    private GameSimulation game;
    private List<String> bridge;

    public BridgeGame() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void createBridge(int size) {
        bridge = bridgeMaker.makeBridge(size);
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String direction) {
        int location = game.getLocation();
        String match = input(direction, bridge.get(location));
        game.print(direction, match);
        if (match.equals("O")) {
            game.addLocation();
        }
        checkMove();
        return match;
    }

    private boolean isCross(int location, String moving) {
        if (bridge.get(location).equals(moving)) {
            return true;
        }
        return false;
    }

    private void checkMove() {
        if (game.getLocation() == bridge.size()) {
            game.setSuccess(true);
        }
    }

    public boolean success() {
        if (game.getSuccess()) {
            return true;
        }
        return false;
    }

    public boolean fail(String match) {
        if (success()) {
            return false;
        }
        if (match.equals("X")) {
            return false;
        }
        return true;
    }

    private String input(String user, String answer) {
        if (!user.equals(answer)) {
            return "X";
        }
        return "O";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        if (!game.getSuccess() && command.equals("R")) {
            return true;
        }
        return false;
    }

    public void newGame() {
        game = new GameSimulation();
    }
}
