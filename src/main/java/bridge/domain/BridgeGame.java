package bridge.domain;

import java.util.List;

public class BridgeGame {

    private static final String INVALID_MOVEMENT_ERROR = "[ERROR] U(위 칸)와 D(아래 칸) 중 하나의 문자만 입력해야 합니다.";
    private static final String INVALID_GAME_COMMAND_ERROR = "[ERROR] R(재시작)과 Q(종료) 중 하나의 문자만 입력해야 합니다.";

    private final Bridge bridge;
    private PlayerData playerData = new PlayerData();

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    public boolean move(String movement) {
        validateMovement(movement);
        playerData.recordMovement(movement);
        if (bridge.contain(playerData.getIndexOfMovement(), movement)) {
            return true;
        }
        return false;
    }

    public boolean retry(String gameCommand) {
        validateGameCommand(gameCommand);
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

    public PlayerData getPlayerData() {
        return playerData;
    }

    private void validateMovement(String movement) {
        if (!movement.equals(Direction.Code.UP.getName()) && !movement.equals(Direction.Code.DOWN.getName())) {
            throw new IllegalArgumentException(INVALID_MOVEMENT_ERROR);
        }
    }

    private void validateGameCommand(String gameCommand) {
        if (!gameCommand.equals("R") && !gameCommand.equals("Q")) {
            throw new IllegalArgumentException(INVALID_GAME_COMMAND_ERROR);
        }
    }
}

