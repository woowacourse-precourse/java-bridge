package bridge.gamebridge;

import bridge.domain.Bridge;
import bridge.option.Move;
import java.util.ArrayList;
import java.util.List;

public class GameBridge {
    private AnswerBridge answerBridge;
    private PlayerBridge playerBridge;

    public GameBridge(){
        this.playerBridge = new PlayerBridge();
    }

    public void generateAnswerBridge(Bridge bridge) {
        this.answerBridge = new AnswerBridge(bridge);
    }
}
