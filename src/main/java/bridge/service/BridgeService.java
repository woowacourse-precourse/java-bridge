package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.Player;

public interface BridgeService {
    Bridge buildBridge(int size);

    Player createPlayer(Bridge bridge);

    void startNewRound(Player player);

    boolean checkMovable(Player player);

    int makeStep(Player player, String step);

    boolean checkSuccess(Player player);


}
