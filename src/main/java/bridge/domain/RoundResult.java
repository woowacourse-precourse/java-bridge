package bridge.domain;

public enum RoundResult {
    PLAYING, FAIL, CLEAR;

    public static RoundResult of(MoveResult moveResult, boolean isClear){
        if(isClear){
            return CLEAR;
        }
        if(moveResult.equals(MoveResult.FAIL)){
            return FAIL;
        }
        return PLAYING;
    }

}
