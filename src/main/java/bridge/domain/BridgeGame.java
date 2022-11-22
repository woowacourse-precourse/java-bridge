package bridge.domain;

import bridge.enums.CommandType;

public class BridgeGame {
    private GameResult gameResult;
    private GameReferee referee;
    private int numberOfAttempts = 1;

    public BridgeGame(Bridge bridge) {
        gameResult = new GameResult();
        referee = new GameReferee(bridge);
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public boolean move(PlayerMoving playerMoving) {
        boolean isCorrect = referee.isCorrectMoving(playerMoving);
        gameResult.addGameResult(isCorrect, playerMoving);
        return isCorrect; //맞추면 true, 틀리면 false
    }

    public boolean retry(PlayerCommand playerCommand) {
        if (playerCommand.equals(CommandType.valueOf("RETRY"))){
            numberOfAttempts++;
            return true;
        }
        return false;
    }
}