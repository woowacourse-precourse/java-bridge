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
    public void printResult(String result, int count) {
        out(OutputMessage.BRIDGE_FINAL);
        out(BridgeGame.gameResult);
        blank();
        out("게임 성공 여부: "+result);
        out("총 시도한 횟수: "+count);
    }
    private void out(String text) {
        System.out.println(text);
    }
    private void blank() {
        System.out.println();
    }
}
