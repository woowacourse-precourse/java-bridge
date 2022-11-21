package bridge;

public class SingleMap {

    BridgeGame bridgeGame;
    String recentMove;

    public SingleMap(BridgeGame bridgeGame,String recentMove){
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
            return Constant.SUCCESS;
        }
        return Constant.BLANK;
    }

    private String lastMoveCheck(String flag){
        if(flag.matches(recentMove)){
            if(bridgeGame.isSuccess()){
                return Constant.SUCCESS;
            }
            return Constant.FAIL;
        }
        return Constant.BLANK;
    }
}
