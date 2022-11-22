package bridge.service;

import bridge.model.AnswerBridge;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/17
 */
public class BridgeService {

    public AnswerBridge find() {
        return AnswerBridge.getInstance();
    }

    public void save(List<String> bridge) {
        AnswerBridge.getInstance().setBridge(bridge);
    }
}
