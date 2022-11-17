package bridge.domain;

import static bridge.utils.Util.getInt;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.InputController;
import bridge.utils.validator.BridgeValidator;
import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final String size;
    private List<String> bridge;
    private int step;

    public Bridge(String size) {
        new BridgeValidator(size);
        this.size = size;
        makeBridgeBySize(getInt(size));
        this.step = 0;
    }

    private void makeBridgeBySize(int size){
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

    private boolean successMove(Move move){
        if(move.goToNextMove(this.bridge.get(this.step))){
            this.step += 1;
            return true;
        }
        return false;
    }


}
