package bridge;


public class BridgeGameController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        BridgeGame bridgeGame = setBridgeGame();
        MapDTO map = startBridgeGame(bridgeGame);
        printResult(bridgeGame, map);
    }

    private void printResult(BridgeGame bridgeGame, MapDTO map) {
        int totalTry = bridgeGame.getPlayerTry();
        boolean winning = bridgeGame.getWinning();
        outputView.printResult(map, winning, totalTry);
    }

    private MapDTO startBridgeGame(BridgeGame bridgeGame) {
        MapDTO map = new MapDTO();
        while(true){
            if (startGameforCheck(bridgeGame, map)) break;
        }
        return map;
    }

    private boolean startGameforCheck(BridgeGame bridgeGame, MapDTO map) {
        String selectedSpace = selectMoving();
        boolean movable = bridgeGame.checkMovable(selectedSpace);
        bridgeGame.transferProgressMap(map, movable, selectedSpace);
        outputView.printMap(map);
        if (checkEndOrContinue(bridgeGame, movable)) {
            return true;
        }
        return false;
    }

    private boolean checkEndOrContinue(BridgeGame bridgeGame, boolean movable) {
        if (checkFailOrPass(bridgeGame, movable)) {
            return true;
        }
        if (bridgeGame.checkEnd()) {
            bridgeGame.winning();
            return true;
        }
        return false;
    }

    private boolean checkFailOrPass(BridgeGame bridgeGame, boolean movable) {
        if (checkRetryWhenFailure(bridgeGame, movable)) {
            return true;
        }
        if (movable) {
            bridgeGame.move();
        }
        return false;
    }

    private boolean checkRetryWhenFailure(BridgeGame bridgeGame, boolean movable) {
        if (!movable) {
            outputView.printRetrySelectMessage();
            String selectedRetry = inputView.readGameCommand();
            if(selectedRetry.equals("Q")){
                return true;
            }
            bridgeGame.retry();
        }
        return false;
    }

    private String selectMoving() {
        outputView.printMoveSelectMessage();
        return inputView.readMoving();
    }

    private BridgeGame setBridgeGame() {
        outputView.printStartMessage();
        outputView.printBridgeSizeInputMessage();

        int size = inputView.readBridgeSize();
        outputView.printEmptyLine();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new BridgeGame(bridgeMaker.makeBridge(size));
    }

}
