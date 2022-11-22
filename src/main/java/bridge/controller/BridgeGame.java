package bridge.controller;

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


    public boolean retry(String command) {

        return command.equals("R");
    }
}
