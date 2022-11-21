package bridge.domain;

import static bridge.utils.Constant.ZERO;
import static bridge.utils.Util.getInt;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.utils.validator.BridgeValidator;
import java.util.List;

public class Bridge {

    private final int size;
    private List<String> bridge;
    private int step;

    public Bridge(String size) {
        new BridgeValidator(size);
        this.size = getInt(size);
        makeBridgeBySize(this.size);
        this.step = ZERO;
    }

    private void makeBridgeBySize(int size){
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public BridgeResult isGoodMove(Move move){
        String nowStep = this.bridge.get(this.step);
        String nowMove = move.getMove();
        boolean nowResult = false;
        if(move.goToNextMove(nowStep)){
            nowResult = true;
        }
        return new BridgeResult(nowMove, nowResult);
    }

    public boolean nowGoodMove(List<BridgeResult> bridgeResults){
        if(bridgeResults.get(this.step).isSuccessMove()){
            return true;
        }
        return false;
    }

    public void resetStep(){
        this.step = -1;
    }

    public boolean notOverStep(){
        if(this.step < this.size){
            return true;
        }
        return false;
    }

    public void goToNextStep(){
        this.step += 1;
    }

}
