package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Player;
import bridge.dto.BridgeDto;
import bridge.dto.PlayerBridgeSizeDto;
import bridge.exception.InputException;

import java.util.List;

public class PlayerSetting {

    private final InputException inputException = new InputException();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private Player player;

    public void setBridgeSizeToPlayer(String readBridgeSize) {
        int bridgeSize = bridgeSizeToInt(readBridgeSize);
        player = new Player(new PlayerBridgeSizeDto(bridgeSize),
                new BridgeDto(bridgeMaker.makeBridge(bridgeSize)));
    }

    private int bridgeSizeToInt(String readBridgeSize) {
        inputException.validateBridgeSize(readBridgeSize);
        return Integer.parseInt(readBridgeSize);
    }

    public int getPlayerBridgeSize() {
        return PlayerBridgeSizeDto.from(player).getBridgeSize();
    }

    public List<String> getPlayerBridge() {
        return BridgeDto.from(player).getBridge();
    }
}
