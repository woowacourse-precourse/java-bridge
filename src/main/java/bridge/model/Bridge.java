package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class Bridge {
    private List<String> blocks;
    public Bridge(int size){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        blocks = bridgeMaker.makeBridge(size);
    }

    public List<String> getBlocks(){
        return blocks;
    }

    public boolean checkBlock(String answer, int round){
        if(answer.equals(blocks.get(round))){
            return true;
        }
        return false;
    }

    public int getSize(){
        return blocks.size();
    }
}
