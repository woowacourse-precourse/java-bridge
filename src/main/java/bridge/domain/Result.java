package bridge.domain;

public class Result {
    private final boolean totalResult;
    private final GameResultType gameResultType;
    public Result(boolean bridgeResult,boolean playerResult){
        this.totalResult = (bridgeResult == playerResult);
        gameResultType = GameResultType.getGameResultType(totalResult,playerResult);
    }
    public GameResultType getResultType(){
        return gameResultType;
    }
}
