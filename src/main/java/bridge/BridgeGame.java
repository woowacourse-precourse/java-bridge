package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Map<Integer, ArrayList<String>> playerBridgeState;
    private final Bridge bridge;
    private int playerBridgePosition = 0;

    public BridgeGame(int bridgeSize) {
        this.playerBridgeState = new HashMap<Integer, ArrayList<String>>() ;
        this.bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize));
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void move() {
    }

    public void addPlayerBridge(String playerAnswer) {
        String Correct = isCorrectInput(bridge.getPositions().get(playerBridgePosition), playerAnswer);

        ArrayList<String> list = new ArrayList<String>();

        list.add(playerAnswer);
        list.add(Correct);

        playerBridgeState.put(playerBridgePosition,list);
    }

    private String isCorrectInput(String playerMovingInRandomBridge, String playerAnswer) {

        if (playerMovingInRandomBridge.equals(playerAnswer)) {
            return "O";
        }
        return "X";
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public Map<Integer, ArrayList<String>> getPlayerBridge() {
        return this.playerBridgeState;
    }

    public String getCurrentIsCorrect() {
        return playerBridgeState.get(playerBridgeState.size()-1).get(1);
    }
}
