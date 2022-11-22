package bridge.Domain;

public class MoveResult {
    private final GameResult gameResult;
    private final DirectionCommand directionCommand;

    public MoveResult(GameResult gameResult, DirectionCommand directionCommand) {
        this.gameResult = gameResult;
        this.directionCommand = directionCommand;
    }

    public boolean failCheck() {
        return gameResult.fail();
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public boolean notSameAfterDirection(DirectionCommand directionCommand) {
        return this.directionCommand.checkSameDirection(directionCommand);
    }

}
