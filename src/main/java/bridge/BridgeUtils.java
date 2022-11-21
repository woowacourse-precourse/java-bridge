package bridge;

import java.util.List;

public class BridgeUtils {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeGame bridgeGame = new BridgeGame();

    public String canPass(final int bridgeNumber) {
        if (bridgeNumber == 0) {
            return "D";
        }
        if (bridgeNumber == 1) {
            return "U";
        }
        return null;
    }

    public void actWhenMoving(final Bridge bridge) {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        outputView.printMap(bridge, bridgeGame.move(bridge, inputView.readMoving()));
    }
}
