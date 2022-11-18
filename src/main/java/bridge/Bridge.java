package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<Integer> bridgeAnswer;

    public List<Integer> getBridgeAnswer() {
        return bridgeAnswer;
    }

    public Bridge(){
        this.bridgeAnswer=List.of(0);
    }
    public Bridge(List<Integer> bridgeAnswer){
        this.bridgeAnswer=bridgeAnswer;
    }

    public List<Integer> toList(){
        return (List<Integer>) bridgeAnswer.stream();
    }
}
