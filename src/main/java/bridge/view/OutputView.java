package bridge.view;

import bridge.message.OutputMessage;
import bridge.model.BridgeGame;

import java.util.List;

public class OutputView {
    BridgeGame bridgeGame = new BridgeGame();
    public void printMap(List<String> movedResult, List<String> bridge) {
        String result = bridgeGame.resultOfPhrase(movedResult, bridge);
        out(result);
        blank();
    }
    public void printResult() {
        out(OutputMessage.BRIDGE_FINAL);
        out(BridgeGame.gameResult);
        blank();
    }
    private void out(String text) {
        System.out.println(text);
    }
    private void blank() {
        System.out.println();
    }
}
