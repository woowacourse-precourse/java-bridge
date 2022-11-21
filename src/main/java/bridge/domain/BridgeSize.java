package bridge.domain;

public class BridgeSize {
    private int size;
    public BridgeSize(int size){
        this.size = size;
    }
    private boolean isvalid(){
        return true;
    }
    public int getSize(){
        return size;
    }
}
