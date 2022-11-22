package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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