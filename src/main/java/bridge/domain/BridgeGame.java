package bridge.domain;

import bridge.enums.CommandType;

public class BridgeGame {
    private GameResult gameResult;
    private GameReferee referee;
    private int bridgeIndex = 0;
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
        boolean isCorrect = referee.isCorrectMoving(playerMoving, bridgeIndex++);
        gameResult.addGameResult(isCorrect, playerMoving);
        if (!isCorrect) {
            bridgeIndex = 0;
        }
        return isCorrect; //맞추면 true, 틀리면 false
    }

    public boolean retry(PlayerCommand playerCommand) {
        if (playerCommand.getCommand().equals(CommandType.valueOf("RETRY").getInitial())){
            numberOfAttempts++;
            gameResult = new GameResult();
            return true;
        }
        return false;
    }
}