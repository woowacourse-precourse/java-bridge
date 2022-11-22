package bridge.repository;

import bridge.domain.CompareBridge;
import bridge.domain.Player;
import java.util.List;

public class CompareBridgeRepository extends CompareBridge {
    public CompareBridgeRepository(List<String> bridge) {
        super(bridge);
    }

    @Override
    public List<Boolean> canStepping(Player player) {
        return super.canStepping(player);
    }
}