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
    private final CountRound countRound;

    PlayGame(CountRound countRound) {
        this.countRound = countRound;
    }
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
        OutputView outputView = new OutputView();
        Map<Integer, Map<String,String>> userStatus = new HashMap<>();
        Condition condition = Condition.PLAY;
        while (condition == Condition.PLAY) {
            userStatus = bridgeGame.move(userStatus, bridge);
            condition = bridgeGame.checkEnd(userStatus, bridge);
            outputView.printMap(userStatus);
        }
        if(condition == Condition.WIN) { end(userStatus); }
        if(condition == Condition.LOOSE) { ask(userStatus, countRound, bridgeGame);}
    }

    public void ask(Map<Integer, Map<String, String>> userStatus, CountRound countRound, BridgeGame bridgeGame) {
        InputWhileException inputWhileException = new InputWhileException();
        String checkEnd= inputWhileException.startWhileReadGameCommand();
        if(checkEnd.equals("Q")) {
            end(userStatus);
        }
        if(checkEnd.equals("R")){
            bridgeGame.retry(bridge, countRound);
        }
    }
    public void end(Map<Integer, Map<String, String>> userStatus) {
        OutputView outputView = new OutputView();
        outputView.printResult(userStatus, countRound);
    }
}
