package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;

import java.util.List;

import static bridge.constants.ConstMessage.*;


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
        return user.get(lastIndex).equals(bridge.getBridge().get(lastIndex));
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

        return command.equals(RETRY);
    }
}
