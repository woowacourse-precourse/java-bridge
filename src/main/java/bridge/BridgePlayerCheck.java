package bridge;

public class BridgePlayerCheck {

    public boolean isO(String bridge, String player, String upDown) {
        return bridge.equals(player) && player.equals(upDown);
    }

    public boolean isX(String bridge, String player, String upDown) {
        return player.equals(upDown) && !player.equals(bridge);
    }
}
