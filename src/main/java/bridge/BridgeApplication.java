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

        doBridgeGame(size); // 다리건너기 시작
        printBridgeGameResult();
    }

    private void printBridgeGameResult() {
        System.out.println(Message.RESULT_MESSAGE);
        printMap();
        outputView.printResult(bridgeGame);
    }

    private void doBridgeGame(int size) {
        for (int idx = 0; idx < size; idx++) {
            bridgeGameMoveAction(idx);
            printMap();
            if (isCorrectMove()) continue;
            if (isSelectExit()) break;
            idx = -1; // 반복문의 idx 를 -1로 돌려주어 다시 0부터 시작할 수 있게끔 함
            plusGameCnt();
        }
    }

    private boolean isSelectExit() {
        bridgeGame.retry(getGameCommand());
        if (bridgeGame.isExit()) return true;
        return false;
    }

    private String getGameCommand() {
        System.out.println(Message.INPUT_GAME_RETRY_OR_EXIT);
        return inputView.readGameCommand();
    }

    private void bridgeGameMoveAction(int idx) {
        bridgeGame.move(inputMoving(), idx);
    }

    private void plusGameCnt() {
        bridgeGame.plusCnt();
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