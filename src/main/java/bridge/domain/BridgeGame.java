package bridge.domain;

import bridge.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private PlayerData playerData = new PlayerData();

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    public BridgeGame(List<String> bridge) {
        this.bridge = new Bridge(bridge);
    }

    public boolean move(String movement) {
        Validator.validateMoving(movement);
        playerData.recordMovement(movement);
        if (bridge.contain(playerData.getIndexOfMovement(), movement)) {
            return true;
        }
        return false;
    }

    public boolean retry(String gameCommand) {
        Validator.validateGameCommand(gameCommand);
        if (gameCommand.equals("R")) {
            playerData.resetMovementHistroy();
            playerData.increaseCountOfTry();
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        if (bridge.isSame(playerData.getMovementHistory())) {
            return true;
        }
        return false;
    }
}

