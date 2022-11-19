package bridge;

import java.util.List;

/**
 * packageName : bridge
 * fileName : BridgeController
 * author : gim-yeong-geun
 * date : 2022/11/19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/19         gim-yeong-geun          최초 생성
 */
public class BridgeController {
    static BridgeGame bridgeGame = new BridgeGame();
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    private static String retryInput = "";
    private static String resultMessage = "최종 게임 결과";
    public void validateMove(List<String> bridge) {
        for (int i = 0; i < bridge.size(); i++) {
            if (bridgeGame.move(bridge.get(i), inputView.readMoving()).equals("X")) {
                outputView.printMap(bridge, BridgeGame.moveMapList);
                i = setRetryInput(bridge, i);
            }
            if (retryInput.equals("Q")) return;
            if (i == bridge.size() - 1) System.out.println(resultMessage);
            if (i >= 0) outputView.printMap(bridge, BridgeGame.moveMapList);
        }
    }

    public static int setRetryInput(List<String> bridge, int index) {
        retryInput = inputView.readGameCommand();
        if (bridgeGame.retry(retryInput, index).equals("R")) {
            index -= 1;
            return index;
        }
        System.out.println(resultMessage);
        outputView.printMap(bridge, BridgeGame.moveMapList);
        outputView.printResult();
        return index;
    }
}
