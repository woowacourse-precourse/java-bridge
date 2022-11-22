package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Player;
import bridge.dto.BridgeCorrectLocationDto;
import bridge.dto.BridgeDto;
import bridge.dto.PlayerBridgeSizeDto;
import bridge.exception.InputException;

import java.util.List;

public class PlayerSetting {

    private static final InputException inputException = new InputException();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static Player player;

    public static void setBridgeSizeToPlayer(String readBridgeSize) {
        int bridgeSize = bridgeSizeToInt(readBridgeSize);
//        player = new Player(new PlayerBridgeSizeDto(bridgeSize),
//                new BridgeDto(bridgeMaker.makeBridge(bridgeSize)));
        player = new Player(bridgeSize, bridgeMaker.makeBridge(bridgeSize));
    }

    private static int bridgeSizeToInt(String readBridgeSize) {
        inputException.validateBridgeSize(readBridgeSize);
        return Integer.parseInt(readBridgeSize);
    }

    public int getPlayerBridgeSize() {
//        return PlayerBridgeSizeDto.from(player).getBridgeSize();
        return player.getBridgeSize();
    }

    public List<String> getPlayerBridge() {
        return BridgeDto.from(player).getBridge();
    }

    public String getBridgeCorrectLocation(int location) {
//        return BridgeCorrectLocationDto.from(player, location).getBridgeCorrectLocation();
        return player.getBridgeCorrectLocation(location);
    }
}
