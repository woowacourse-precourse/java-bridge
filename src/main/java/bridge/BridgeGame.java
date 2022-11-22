package bridge;
import java.util.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private BridgeMaker bridgeMaker;
    private List<String> bridge;
    private Game game;

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
        String checkOX = checkOX(direction, bridge.get(game.getLocation()));

        if (checkOX.equals("O")) {
            game.forward();
        }

        if(game.getLocation() == bridge.size()) {
            game.setSuccess("성공");
        }

        return checkOX;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {

    }

    public String checkOX(String user, String answer) {
        if (!user.equals(answer)) return "X";
        return "O";
    }

    public boolean check(String checkOX) {
        if (game.getSuccess().equals("성공")) {
            return false;
        }
        if (checkOX.equals("X")) {
            return false;
        }
        return true;
    }
}
