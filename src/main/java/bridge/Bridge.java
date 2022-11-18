package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<Integer> bridgeAnswer;

    public List<Integer> getBridgeAnswer() {
        return bridgeAnswer;
    }

    public Bridge(List<Integer> bridgeAnswer){
        this.bridgeAnswer=bridgeAnswer;
    }
}
