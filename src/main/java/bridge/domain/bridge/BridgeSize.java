package bridge.domain.bridge;

import bridge.error.ErrorHandler;

public class BridgeSize {
    private int size;
    public BridgeSize(int size){
        this.size = size;
        isValid();
    }
    private void isValid(){
        if (size<3 || size>20) {
            ErrorHandler.inputNumberException();
        }
    }
    public int getSize(){
        return size;
    }
}
