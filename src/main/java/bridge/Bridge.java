package bridge;

import java.util.List;
import static Constant.MoveCondition.*;
import static Constant.ErrorMessage.ILLEGAL_LIST_INDEX;
public class Bridge {
    private List<String> bridgeRoute;
    private int bridgeLength;
    private int currentPosition;
    InputView userInput;
    Bridge(){
        userInput = new InputView();
        bridgeLength = userInput.readBridgeSize();
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeRoute = maker.makeBridge(bridgeLength);
        currentPosition=-1;
    }
    public boolean nextStep(){
        currentPosition++;
        if(currentPosition>=bridgeLength){
            throw new IllegalArgumentException(ILLEGAL_LIST_INDEX.getErrorMsg());
        }
        String direction = userInput.readMoving();
        return isSafe(direction);

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
    private boolean isArrive(){
        if(currentPosition==bridgeLength){
            return true;
        }
        return false;
    }
    public void printRoute(){
        System.out.println(bridgeLength);
    }
    public void resetStep(){
        currentPosition = -1;
    }
}
