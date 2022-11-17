package bridge.service;

import bridge.domain.Player;
import bridge.dto.PlayerBridgeSizeDto;

public class PlayerSetting {

    private Player player;

    public void setBridgeSizeToPlayer(String readBridgeSize) {
        player = new Player(new PlayerBridgeSizeDto(bridgeSizeToInt(readBridgeSize)));
    }

    private int bridgeSizeToInt(String readBridgeSize) {
        if (validateBridgeSize()) {
            // 예외 처리
        }
        return Integer.parseInt(readBridgeSize);
    }

    private boolean validateBridgeSize() {
        /*
        예외 처리
        1. 숫자로 입력 안하면 예외를 던짐
        2. 다리의 길이를 3미만 20초과로 입력한 경우 예외를 던짐
         */
        return true;
    }

    public int getPlayerBridgeSize() {
        return PlayerBridgeSizeDto.from(player).getBridgeSize();
    }
}
