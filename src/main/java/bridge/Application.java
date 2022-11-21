package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> bridge = getBridge(inputView, outputView, bridgeMaker);
            BridgeGame bridgeGame = new BridgeGame(bridge);
            playGame(inputView, outputView, bridgeGame);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private static List<String> getBridge(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        outputView.printStart();
        int size = getSize(inputView, outputView);
        return bridgeMaker.makeBridge(size);
    }

    private static int getSize(InputView inputView, OutputView outputView) {
        outputView.printInputBridgeLength();
        String input = inputView.input();
        return inputView.readBridgeSize(input);
    }

    private static void playGame(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        while (true) {
            String board = getBoard(inputView, outputView);
            bridgeGame.move(board);
            List<String> upBoardCheckList = bridgeGame.getUpBoardCheckList();
            List<String> downBoardCheckList = bridgeGame.getDownBoardCheckList();
            outputView.printMap(upBoardCheckList, downBoardCheckList);
            if (isQuit(inputView, outputView, bridgeGame)) break;
            if (bridgeGame.getSuccess()) break;
        }
        outputView.printResult(bridgeGame);
    }

    private static boolean isQuit(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        if (!bridgeGame.getMoveSuccess()) {
            outputView.printInputRetry();
            String retryInput = inputView.input();
            String retry = inputView.readGameCommand(retryInput);
            if (retry.equals("R")) {
                bridgeGame.retry();
            }
            return retry.equals("Q");
        }
        return false;
    }

    private static String getBoard(InputView inputView, OutputView outputView) {
        outputView.printInputBoard();
        String inputBoard = inputView.input();
        return inputView.readMoving(inputBoard);
    }
}
