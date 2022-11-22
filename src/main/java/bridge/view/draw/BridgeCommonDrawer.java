package bridge.view.draw;

import bridge.domain.MovingCommand;
import java.util.List;

public class BridgeCommonDrawer extends BridgeDrawer {

    private final List<String> userBridge;

    public BridgeCommonDrawer(List<String> userBridge) {
        this.userBridge = userBridge;
    }

    @Override
    protected void makeBridgeFormat() {
        for (String command : userBridge) {
            addWordIfMatches(command, MovingCommand.UP, Marker.CORRECT, Marker.EMPTY);
            addWordIfMatches(command, MovingCommand.DOWN, Marker.EMPTY, Marker.CORRECT);
        }
    }
}
