package bridge.domain;

import static bridge.utils.Util.getInt;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.InputController;
import bridge.utils.validator.BridgeValidator;
import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final int size;
    private List<String> bridge;
    private int step;

    public Bridge(String size) {
        new BridgeValidator(size);
        this.size = getInt(size);
        makeBridgeBySize(this.size);
        this.step = step;
    }

    private void makeBridgeBySize(int size){
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public String successUpMove(Move move){
        String result = "";
        if(move.isUpMove()){
            result = successMove(move);
        }
        return result;
    }

    public String successDownMove(Move move){
        String result = "";
        if(!move.isUpMove()){
            result = successMove(move);
        }
        return result;
    }

    private String successMove(Move move){
        if(move.goToNextMove(this.bridge.get(this.step))){
            this.step += 1;
            return "O";
        }
        return "X";
    }


}
