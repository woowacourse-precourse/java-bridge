package bridge.model;

import bridge.BridgeMaker;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private User user;
    private Bridge bridge;
    BridgeMaker bridgeMaker;

    public BridgeGame() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }
    public List<String> move(String input) {
        String move = new Move(input).getMove();
        if (!checkMove(move)) {
            user.setState(GameState.Over.getState());
            move += "X";
        } else if (user.getBridgeState().size() + 1 == bridge.getAnswer().size()) {
            user.setState(GameState.Success.getState());
        }
        user.addBridgeState(move);
        return user.getBridgeState();
    }

    private boolean checkMove(String move) {
        if (move.equals(bridge.getAnswer().get(user.getBridgeState().size()))) {
            return true;
        }
        return false;
    }

    public void setBridge(String input) {
        bridge = new Bridge(input);
        user = new User();
        setBridgeAnswer(bridgeMaker.makeBridge(bridge.getSize()));
    }
    public void setBridgeAnswer(List<String> answer) {
        bridge.setAnswer(answer);
    }

    public void retry() {
        user.addTryTime();
        user.setState(GameState.Playing.getState());
        user.setBridgeState(new ArrayList<String>());
    }

    public String getUserState() {
        return user.getState();
    }

    public List<String> getBridgeState() {
        return user.getBridgeState();
    }

    public int getTryTime() {
        return user.getTryTime();
    }
}
