package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameService {

    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameService() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public List<String> getBridge() {
        int size = getInputBridgeSize();
        return bridgeMaker.makeBridge(size);
    }

    private int getInputBridgeSize() {
        outputView.printStartMessage();
        outputView.printInputBridgeSize();
        return inputView.readBridgeSize();
    }

    public void gameStart(List<String> randomBridge) {
        BridgeGame bridgeGame = new BridgeGame(randomBridge);
        while (true) {
            String board = getBoard(inputView, outputView);
            bridgeGame.move(board);
            List<String> upBoardCheckList = bridgeGame.getUpBoardList();
            List<String> downBoardCheckList = bridgeGame.getDownBoardList();
            outputView.printMap(upBoardCheckList, downBoardCheckList);
            if (isQuit(inputView, outputView, bridgeGame) || bridgeGame.getSuccess()) break;
        }
        outputView.printResult(bridgeGame);
    }

    private String getBoard(InputView inputView, OutputView outputView) {
        outputView.printInputBoard();
        return inputView.readMoving();
    }

    private static boolean isQuit(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        if (!bridgeGame.getMoveSuccess()) {
            outputView.printInputRetry();
            String retry = inputView.readGameCommand();
            if (retry.equals("R")) {
                bridgeGame.retry();
            }
            return retry.equals("Q");
        }
        return false;
    }
}
