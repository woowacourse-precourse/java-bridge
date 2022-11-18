package bridge;

import java.util.List;

public class Bridge {
    private List<String> answerBridge;

    public Bridge(List<String> answerBridge) {
        this.answerBridge = answerBridge;
    }

    public boolean isRightDirection(int idx, String direction){
        if(answerBridge.get(idx).equals(direction)){
            return true;
        }
        return false;
    }
}
