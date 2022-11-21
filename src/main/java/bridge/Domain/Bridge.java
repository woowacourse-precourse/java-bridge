package bridge.Domain;

import bridge.BridgeMaker;

import java.util.List;

public class Bridge {
    private List<String> spaces;
    private final BridgeMaker bridgeMaker;

    public Bridge(BridgeMaker bridgeMaker){
        this.bridgeMaker = bridgeMaker;
    }

    public void makeBridge(int size){
        spaces = bridgeMaker.makeBridge(size);
    }

    public int getSize(){
        return spaces.size();
    }

    public List<String> getSpaces() {
        return spaces;
    }
}
