package bridge.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class BridgeGame {
    private Bridge bridge;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    public void move(String inputBridge) {
        Player player = new Player(inputBridge);
        bridge.runBridge(player.getNextCurrent());
    }

    public void retry() {
        bridge.clearPlayerBridge();
    }
}
