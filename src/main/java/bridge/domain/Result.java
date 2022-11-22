package bridge.domain;

public class Result {
    private final GameResultType gameResultType;
    public Result(boolean bridgeResult,boolean playerResult){
        gameResultType = GameResultType.getGameResultType((bridgeResult == playerResult),playerResult);
    }
    public GameResultType getResultType(){
        return gameResultType;
    }
}
