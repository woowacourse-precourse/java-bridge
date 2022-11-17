package bridge.service;

import bridge.Exception.InputException;
import bridge.domain.Player;
import bridge.dto.PlayerBridgeSizeDto;

public class PlayerSetting {

    private Player player;
    private InputException inputException;

    public void setBridgeSizeToPlayer(String readBridgeSize) {
        player = new Player(new PlayerBridgeSizeDto(bridgeSizeToInt(readBridgeSize)));
    }

    private int bridgeSizeToInt(String readBridgeSize) {
        inputException.validateBridgeSize(readBridgeSize);
        return Integer.parseInt(readBridgeSize);
    }

    public int getPlayerBridgeSize() {
        return PlayerBridgeSizeDto.from(player).getBridgeSize();
    }
}
