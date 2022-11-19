package bridge;

import javax.naming.ldap.Control;
import java.util.List;

public class Controller {

    private int attempts = 1;
    private boolean isContinue = true;
    private boolean isWin;
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    BridgeGame bridgeGame = new BridgeGame();
    OutputView outputView = new OutputView();
    Util util = new Util();
    List<String> crossable;
    int limitSize;
    Map map;

    public Controller() {
        this.limitSize = util.determineBridgeSize();
        this.crossable =bridgeMaker.makeBridge(limitSize);
        map = new Map(crossable);
    }

    public void play() {
        while (isContinue) {
            isWin = bridgeGame.checkIfWin(crossable, map);
            isContinue = bridgeGame.checkIfRetry(isWin);
            if (!isContinue) {
                outputView.printResult(map,isWin,attempts);
            }
            attempts++;
        }
    }

}
