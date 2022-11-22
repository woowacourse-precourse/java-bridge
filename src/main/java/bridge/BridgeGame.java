package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private final Bridge bridge;
    private Map<Integer, ArrayList<String>> playerBridgeState;

    private int playerBridgePosition = 0;
    private int attempts = 1;
    private boolean isSuccess = true;

    public BridgeGame(int bridgeSize) {
        this.playerBridgeState = new HashMap<Integer, ArrayList<String>>();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public void changeToLoose() {
        this.isSuccess = false;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        playerBridgePosition++;
    }

    public void addPlayerBridge(String playerAnswer) {
        String Correct = isCorrectInput(bridge.getPositions().get(playerBridgePosition), playerAnswer);

        ArrayList<String> list = new ArrayList<String>();

        list.add(playerAnswer);
        list.add(Correct);

        playerBridgeState.put(playerBridgePosition, list);
    }

    public String isCorrectInput(String playerMovingInRandomBridge, String playerAnswer) {

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
        this.playerBridgeState = new HashMap<Integer, ArrayList<String>>();
        playerBridgePosition = 0;
        attempts++;
    }

    public boolean checkCanMove() {
        if (playerBridgeState.get(playerBridgeState.size() - 1).get(1).equals("O") && playerBridgePosition < (bridge.getPositions().size())) {
            return true;
        }
        return false;
    }

    public Map<Integer, ArrayList<String>> getPlayerBridge() {
        return this.playerBridgeState; //무조건 필요함
    }

    public String getCurrentIsCorrect() {
        return playerBridgeState.get(playerBridgeState.size() - 1).get(1);
    }

    public int getCountAttempts() {
        return this.attempts;
    }

    public int getPlayerBridgePosition() {
        return this.playerBridgePosition;
    }

    public boolean getIsSuccess() {
        return this.isSuccess;
    }
}