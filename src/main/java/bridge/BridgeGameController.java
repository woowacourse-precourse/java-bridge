package bridge;

import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.ErrorMsg;
import bridge.model.Player;
import bridge.view.GameMsg;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private BridgeGame bridgeGame;
    private final OutputView outputView = new OutputView();
    private final Player player = new Player();
    private final InputView inputView = new InputView();


    public void start() {
        try {
            System.out.println(GameMsg.INIT_MSG.getMsg() + "\n");
            bridgeInit();
            boolean isFail = goThroughBridge();
            finishGame(isFail);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMsg.PREFIX.getMsg() + e.getMessage());
        }
    }

    public void bridgeInit() {
        int size = inputView.readBridgeSize();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(size));
    }

    public boolean goThroughBridge() {
        boolean isFail;
        do {
            isFail = moveToNext();
            if (isFailAndQuit(isFail)) {
                break;
            }
        } while (bridgeGame.isGameLeft(player));

        return isFail;
    }

    private boolean moveToNext() {
        String dir = inputView.readMoving();
        player.chooseDir(dir);
        boolean isFail = bridgeGame.move(player);
        outputView.printMap(player.getSelectedBridge(), isFail);
        return isFail;
    }

    private boolean isFailAndQuit(boolean isFail) {
        if (isFail) {
            player.reset();
            return isNotRetry();
        }
        return false;
    }

    private boolean isNotRetry() {
        String input = inputView.readGameCommand();
        if (bridgeGame.retry(input)) {
            player.reset();
            return false;
        }
        return true;
    }

    private void finishGame(boolean isFail) {
        System.out.println(GameMsg.RESULT_MSG.getMsg());
        outputView.printMap(player.getSelectedBridge(), isFail);
        outputView.printResult(isFail, bridgeGame.getTimes());
    }

}
