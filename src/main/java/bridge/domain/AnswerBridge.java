package bridge.domain;

;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class AnswerBridge {
    public int size;
    private static List<String> answer;

    public AnswerBridge(int size){
        this.size = size;
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        this.answer = bridgeMaker.makeBridge(size);
    }

    public static AnswerBridge generateAnswerBridge(int size){
        return new AnswerBridge(size);
    }
    public static List<String> getAnswer(){
        return answer;
    }
}

