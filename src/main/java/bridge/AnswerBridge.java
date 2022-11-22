package bridge;

import org.mockito.stubbing.Answer;

;import java.util.ArrayList;
import java.util.List;

public class AnswerBridge {
    public int size;
    static List<String> answer;

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

