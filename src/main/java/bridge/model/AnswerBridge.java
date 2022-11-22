package bridge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/20
 */
public class AnswerBridge {
    private static AnswerBridge bridgeAnswer;   // 싱글톤 패턴 적용
    private List<String> bridge;

    private AnswerBridge() {
        bridge = new ArrayList<>();
    }

    public static AnswerBridge getInstance() {
        if(bridgeAnswer == null) {
            synchronized(AnswerBridge.class)
            {
                bridgeAnswer = new AnswerBridge();
            }
        }
        return bridgeAnswer;
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public int getSize() {
        return bridge.size();
    }
}
