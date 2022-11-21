package bridge.repository;

import bridge.domain.CompareBridge;
import bridge.domain.Player;
import java.util.List;

public class CompareBridgeRepository extends CompareBridge {
    public CompareBridgeRepository(Player player, List<String> bridge) {
        super(player, bridge);
    }

    @Override
    public boolean stepping(Player player, List<String> bridge) {
        return super.stepping(player, bridge);
    }
}