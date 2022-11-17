package bridge.domain.repository;

import bridge.application.BridgeGame;
import bridge.presentation.dto.BridgeSize;
import bridge.presentation.dto.GameCommand;
import bridge.presentation.dto.SelectMove;

import java.util.ArrayList;
import java.util.List;

public class BridgeRepository {
    private static final BridgeRepository instance=new BridgeRepository();
    private List<String> bridge;
    private List<String> upperResult;
    private List<String> lowerResult;
    private BridgeSize bridgeSize;
    private SelectMove selectMove;
    private GameCommand gameCommand;
    private Integer attemptNumber;
    private Integer successNumber;
    private BridgeRepository(){
        attemptNumber=1;
    }

    public static BridgeRepository getInstance(){
        return instance;
    }
    public void setResult(){
        upperResult=new ArrayList<>(List.of("["));
        lowerResult=new ArrayList<>(List.of("["));
        successNumber=0;

    }
    public void updateAttemptNumber(){
        attemptNumber+=1;
    }
    public void updateSuccessNumber(){
        successNumber+=1;
    }
    public void addUpperResult(String result){
        upperResult.add(result);
    }
    public void addLowerResult(String result){
        lowerResult.add(result);
    }

    public void saveBridgeSize(BridgeSize bridgeSize){
        this.bridgeSize=bridgeSize;
    }
    public void saveSelectMove(SelectMove selectMove){this.selectMove=selectMove;}
    public void saveGameCommand(GameCommand gameCommand){this.gameCommand=gameCommand;}
    public void updateBridge(List<String> bridge){this.bridge=bridge;}

    public BridgeSize getBridgeSize() {
        return bridgeSize;
    }
    public SelectMove getSelectMove() {
        return selectMove;
    }

    public GameCommand getGameCommand() {
        return gameCommand;
    }

    public List<String> getBridge() {
        return bridge;
    }
    public List<String> getUpperResult() {
        return upperResult;
    }
    public List<String> getLowerResult() {
        return lowerResult;
    }

    public Integer getSuccessNumber() {
        return successNumber;
    }

    public Integer getAttemptNumber() {
        return attemptNumber;
    }
}
