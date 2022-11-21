package bridge.view.draw;

import bridge.domain.MovingCommand;
import java.util.List;

public class BridgeFailDrawer extends BridgeDrawer {

    private final List<String> userBridge;

    public BridgeFailDrawer(List<String> userBridge) {
        this.userBridge = userBridge;
    }

    @Override
    protected void makeBridgeFormat() {
        commonMakeBridgeFormat();
        int lastIndex = userBridge.size() - 1;
        String command = userBridge.get(lastIndex);
        addWordIfMatches(command, MovingCommand.UP, "X", " ");
        addWordIfMatches(command, MovingCommand.DOWN, " ", "X");
    }

    private void commonMakeBridgeFormat() {
        for (int i = 0; i < userBridge.size() - 1; ++i) {
            String command = userBridge.get(i);
            addWordIfMatches(command, MovingCommand.UP, "O", " ");
            addWordIfMatches(command, MovingCommand.DOWN, " ", "O");
        }
    }
}
