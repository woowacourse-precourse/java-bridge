package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static Constant.MoveCondition.*;
import static Constant.ErrorMessage.ILLEGAL_LIST_INDEX;
import static Constant.BridgeMakerConstant.*;
import static Constant.GameCondition.*;
public class Bridge {
    private List<String> bridgeRoute;
    private List<List<String>> stepMemory;
    private List<Boolean> safeMemory;
    private int bridgeLength;
    private int currentPosition;
    static final String blank = " ";
    InputView userInput;
    Bridge(){
        userInput = new InputView();
        bridgeLength = userInput.readBridgeSize();
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeRoute=maker.makeBridge(bridgeLength);
        stepMemory = new ArrayList<>();
        for(int i=0; i<BRIDGE_ROUTE.getBranchNum(); i++){
            stepMemory.add(new ArrayList<>());
        }
        safeMemory = new ArrayList<>();
        currentPosition=-1;
    }


    public boolean nextStep(){
        currentPosition++;
        if(currentPosition>=bridgeLength){
            throw new IllegalArgumentException(ILLEGAL_LIST_INDEX.getErrorMsg());
        }
        String direction = userInput.readMoving();
        boolean stepResult = isSafe(direction);
        safeMemory.add(stepResult);
        drawStep(direction);
        return stepResult;

    }
    private boolean isSafe(String direction){
        if (bridgeRoute.get(currentPosition).equals(direction)){
            return SUCCESS.getCond();
        }
        if (!bridgeRoute.get(currentPosition).equals(direction)){
            return FAIL.getCond();
        }
        throw new RuntimeException("존재하지 않는 move명령이 들어왔습니다.");
    }
    public boolean isArrive(){
        if(currentPosition==bridgeLength-1){
            return true;
        }
        return false;
    }
    public void drawStep(String direction){
        String targetShape;
        if(safeMemory.get(currentPosition)) {
            targetShape = "O";
        }else{
            targetShape = "X";
        }
        for(int i=0; i<BRIDGE_ROUTE.getBranchNum(); i++){
            if(i == BRIDGE_ROUTE.getHash().get(direction)){
                stepMemory.get(i).add(targetShape);
                continue;
            }
            stepMemory.get(i).add(blank);
        }
    }
    public List<List<String>> getStepMemory(){
        return stepMemory;
    }
    public boolean resetStep(){
        boolean choice = userInput.isRestart();
        if(choice) {
            currentPosition = -1;
            for(List<String > step : stepMemory){
                step.clear();
            }
            safeMemory = new ArrayList<>();
        }
        return choice;
    }
}
