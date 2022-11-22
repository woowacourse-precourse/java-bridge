package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    BridgeMaker bridgeMaker;
    Bridge bridge;

    public BridgeGame() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void makeBridge(int size) {
        this.bridge = new Bridge(bridgeMaker.makeBridge(size));
    }


    public boolean move(List<String> user) {
        int lastIndex = user.size() - 1;
        if (user.get(lastIndex).equals(bridge.getBridge().get(lastIndex))) {
            return true;
        }
        return false;
    }

    public boolean checkGameSucccess(List<String> user) {
        int size = user.size();
        if (bridge.getBridge().size() == size) {
            if (bridge.getBridge().get(size - 1).equals(user.get(size - 1))) {
                return true;
            }
        }
        return false;
    }

    public boolean checkGameFinish(List<String> user) {
        List<String> checkBridge = bridge.getBridge();
        int lastIndex = checkBridge.size();
        if (user.size() == lastIndex) {
            return user.get(lastIndex-1).equals(checkBridge.get(lastIndex-1));
        }
        return false;
    }


    public boolean retry(String command) {

        return command.equals("R");
    }
}
