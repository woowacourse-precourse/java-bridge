package bridge;

public class SingleMap {

    BridgeGame bridgeGame;
    String recentMove;

    static final String SUCCESS="O";
    static final String FAIL="X";
    static final String BLANK=" ";

    SingleMap(BridgeGame bridgeGame,String recentMove){
        this.bridgeGame=bridgeGame;
        this.recentMove=recentMove;
    }

    public String convertToSingleMap(String flag){
        StringBuilder singleMap=new StringBuilder();
        for(int convertIndex=0; !bridgeGame.checkPlayerPosition(convertIndex+1);convertIndex++){
            singleMap.append(checkSuccess(flag,convertIndex));
        }
        singleMap.append(lastMoveCheck(flag));
        return singleMap.toString();
    }

    private String checkSuccess(String flag,int convertIndex){
        if(bridgeGame.checkSuccess(flag,convertIndex)){
            return SUCCESS;
        }
        return BLANK;
    }

    private String lastMoveCheck(String flag){
        if(flag.matches(recentMove)){
            if(bridgeGame.isSuccess()){
                return SUCCESS;
            }
            return FAIL;
        }
        return BLANK;
    }
}
