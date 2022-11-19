package bridge.dto;

import bridge.domain.Player;

public class BridgeCorrectLocationDto {
    private final String bridgeCorrectLocation;

    public BridgeCorrectLocationDto(String bridgeCorrectLocation) {
        this.bridgeCorrectLocation = bridgeCorrectLocation;
    }

    public static BridgeCorrectLocationDto from(Player player, int location) {
        return new BridgeCorrectLocationDto(player.getBridgeCorrectLocation(location));
    }

    public String getBridgeCorrectLocation() {
        return bridgeCorrectLocation;
    }
}
