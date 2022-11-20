package bridge;

import java.util.List;
import static Constant.MoveCondition.*;
public class Bridge {
    private List<String> bridgeRoute;
    private int bridgeLength;
    InputView userInput;
    Bridge(){
        userInput = new InputView();
        bridgeLength = userInput.readBridgeSize();
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeRoute = maker.makeBridge(bridgeLength);
    }
    public boolean isSafe(int index){
        String direction = userInput.readMoving();
        if (bridgeRoute.get(index) == direction){
            return SUCCESS.getCond();
        }
        if (bridgeRoute.get(index) !=direction){
            return FAIL.getCond();
        }
        return false;
    }
}
