package bridge;

import java.util.List;

public class BridgeApplication {
    private InputView inputView;
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private BridgeMaker bridgeMaker;
    private OutputView outputView;
    private BridgeGame bridgeGame;

    private List<String> bridge;

    void run() {
        System.out.println(Message.START_MESSAGE); // 다리 건너기 게임 시작
        int size = inputBridgeSize(); // 다리의 길이를 입력
        makeBridge(size); // 다리를 만듦
        outputView = new OutputView();
        bridgeGame = new BridgeGame(bridge, 1);

        doBridgeGame(); // 다리건너기 시작
        printBridgeGameResult();
    }

    private void printBridgeGameResult() {
        System.out.println(Message.RESULT_MESSAGE);
        printMap();
        outputView.printResult(bridgeGame);
    }

    private void doBridgeGame() {
        while (!isCorrectMove()) {
            bridgeGameMoveAction();
            printMap();
            if(bridgeGame.isExit()){
                bridgeGame.retry(getGameCommand());
            }
        }
    }

    private String getGameCommand() {
        System.out.println(Message.INPUT_GAME_RETRY_OR_EXIT);
        return inputView.readGameCommand();
    }

    private void bridgeGameMoveAction() {
        bridgeGame.move(inputMoving());
    }

    private void printMap() {
        outputView.printMap(bridgeGame);
    }

    private boolean isCorrectMove() {
        if (bridgeGame.isMove()) {
            return true;
        }
        return false;
    }

    private String inputMoving() {
        System.out.println(Message.INPUT_MOVE_U_OR_D);
        String moving = inputView.readMoving();
        return moving;
    }

    private void makeBridge(int size) {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = bridgeMaker.makeBridge(size);
    }

    private int inputBridgeSize() {
        System.out.println(Message.INPUT_BRIDGE_SIZE);
        inputView = new InputView();
        int size = inputView.readBridgeSize();
        return size;
    }
}