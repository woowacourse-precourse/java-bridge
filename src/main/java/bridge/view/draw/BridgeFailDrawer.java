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
        addWordIfMatches(command, MovingCommand.UP, Marker.IN_CORRECT, Marker.EMPTY);
        addWordIfMatches(command, MovingCommand.DOWN, Marker.EMPTY, Marker.IN_CORRECT);
    }

    private void commonMakeBridgeFormat() {
        for (int i = 0; i < userBridge.size() - 1; ++i) {
            String command = userBridge.get(i);
            addWordIfMatches(command, MovingCommand.UP, Marker.CORRECT, Marker.EMPTY);
            addWordIfMatches(command, MovingCommand.DOWN, Marker.EMPTY, Marker.CORRECT);
        }
    }
}
