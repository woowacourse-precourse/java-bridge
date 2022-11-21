package bridge.view.output;

import bridge.model.BridgeGame;

public interface OutputInterface {

    void PrintMap(BridgeGame game);
    String makeLine(BridgeGame game, String type);
    String checkUpOrNot(BridgeGame game, int index, String type);
    String checkLast(BridgeGame game, int index);
    void printResult(BridgeGame game, int winType);
    void distinguishWinType(BridgeGame game, int winType);
}
