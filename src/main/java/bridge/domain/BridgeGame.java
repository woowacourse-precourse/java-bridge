package bridge.domain;

import java.util.List;

public class BridgeGame {

    private static final String INVALID_MOVEMENT_ERROR = "[ERROR] U(위 칸)와 D(아래 칸) 중 하나의 문자만 입력해야 합니다.";
    private static final String INVALID_GAME_COMMAND_ERROR = "[ERROR] R(재시작)과 Q(종료) 중 하나의 문자만 입력해야 합니다.";
    private static final String RETRY_COMMAND_CODE = "R";
    private static final String QUIT_COMMAND_CODE = "Q";
    private static final int INITIAL_VALUE_OF_TRY_COUNT = 1;

    private final Bridge bridge;
    private final Map map;
    private int countOfTry;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        map = new Map();
        countOfTry = INITIAL_VALUE_OF_TRY_COUNT;
    }

    public boolean move(String movement) {
        validateMovement(movement);
        map.drawMovement(movement);
        boolean hasMoved = bridge.contain(map.getLength() - 1, movement);
        map.replaceLastToFailMark(hasMoved);
        if (hasMoved) {
            return true;
        }
        return false;
    }

    public boolean retry(String gameCommand) {
        validateGameCommand(gameCommand);
        if (gameCommand.equals(RETRY_COMMAND_CODE)) {
            map.clear();
            countOfTry++;
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        if (bridge.getLength() == map.getLength() && !map.hasFailMark()) {
            return true;
        }
        return false;
    }

    public int getCountOfTry() {
        return countOfTry;
    }

    public List<String> getResult() {
        return map.getMap();
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

