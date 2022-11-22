package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.MoveSpace;
import bridge.view.InputView;

public class InputController {

    public static Bridge getBridge(){
        return new Bridge(InputView.readBridgeSize());
    }
    public static MoveSpace getMoving(){
        return new MoveSpace(InputView.readMoving());
    }

    public static boolean retryOrGameOver(){
        if(InputView.readGameCommand().equals("R")){
            return true;
        }
        return false;
    }
}
