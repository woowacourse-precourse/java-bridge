package bridge.domain;

public class BridgeGame {

    private static final String INVALID_MOVEMENT_ERROR = "[ERROR] U(위 칸)와 D(아래 칸) 중 하나의 문자만 입력해야 합니다.";
    private static final String INVALID_GAME_COMMAND_ERROR = "[ERROR] R(재시작)과 Q(종료) 중 하나의 문자만 입력해야 합니다.";
    private static final String RETRY_COMMAND_CODE = "R";
    private static final String QUIT_COMMAND_CODE = "Q";

    private final Bridge bridge;
    private final PlayerData playerData = new PlayerData();

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    public boolean move(String movement) {
        validateMovement(movement);
        playerData.add(movement);
        if (bridge.contain(playerData.getIndexOfMovementRecord(), movement)) {
            return true;
        }
        return false;
    }

    public boolean retry(String gameCommand) {
        validateGameCommand(gameCommand);
        if (gameCommand.equals(RETRY_COMMAND_CODE)) {
            playerData.clearMovementRecord();
            playerData.increaseCountOfTry();
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        if (bridge.isSame(playerData.getMovementRecord())) {
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
        if (!gameCommand.equals(RETRY_COMMAND_CODE) && !gameCommand.equals(QUIT_COMMAND_CODE)) {
            throw new IllegalArgumentException(INVALID_GAME_COMMAND_ERROR);
        }
    }

}

