package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> bridgeAnswer;

    public List<String> getBridgeAnswer() {
        return bridgeAnswer;
    }
    public void setBridgeAnswer(List<String> bridgeAnswer){
        this.bridgeAnswer=bridgeAnswer;
    }

    public Bridge(){
        this.bridgeAnswer=List.of(Constant.UP);
    }
    public Bridge(List<String> bridgeAnswer){
        this.bridgeAnswer=bridgeAnswer;
    }

    public List<String> toList(){
        return (List<String>) bridgeAnswer.stream();
    }
}
