package bridge;

import bridge.UI.Input.InputWhileException;
import bridge.UI.Output.CountRound;
import bridge.UI.Output.OutputString;
import bridge.UI.Output.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayGame {
    private List<String> bridge;
    private CountRound countRound;

    PlayGame() {}
    PlayGame(List<String> bridge, CountRound countRound) {
        this.bridge = bridge;
        this.countRound = countRound;
    }

    public void start() {
        System.out.println(OutputString.START.getMessage());
        InputWhileException input = new InputWhileException();
        int bridgeSize = input.startWhileReadBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(() -> new BridgeRandomNumberGenerator().generate());
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
        play();
    }

    public void play() {
        BridgeGame bridgeGame = new BridgeGame();
        Map<Integer, Map<String,String>> userStatus = new HashMap<>();
        Condition condition = Condition.PLAY;
        while (condition == Condition.PLAY) {
            userStatus = bridgeGame.move(userStatus, bridge);
            condition = bridgeGame.checkEnd(userStatus, bridge);
        }
        if(condition == Condition.WIN) { end(userStatus, countRound); }
        if(condition == Condition.LOOSE) { bridgeGame.retry(bridge, countRound); }
    }

    public void end(Map<Integer, Map<String, String>> userStatus, CountRound countRound) {
        OutputView outputView = new OutputView();
        outputView.printResult(userStatus, countRound);
    }
}
