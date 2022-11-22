package bridge;

import java.util.List;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static int tryNumber = 1;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        tryNumber = 1;
        game(new Bridge(), new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize())));
    }

    public static void game(Bridge currentBridge, Bridge answerBridge) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        while (currentBridge.equals(answerBridge) && currentBridge.getBridge().size() < answerBridge.getBridge().size()) {
                move(currentBridge, answerBridge);
        }
        outputView.printResult(tryNumber, currentBridge, answerBridge);
        makeResult(currentBridge, answerBridge);
    }

    public static void move(Bridge currentBridge, Bridge answerBridge) {
        bridgeGame.move(currentBridge, inputView.readMoving());
        outputView.printMap(currentBridge, answerBridge);
    }
    public static void makeResult(Bridge currentBridge, Bridge answerBridge){
        boolean gameResult = currentBridge.equals(answerBridge);
        String command = "Q";
        if (!gameResult) {
            command = inputView.readGameCommand();
        }
        if (command.equals("R")) {
            bridgeGame.retry(currentBridge);
            tryNumber++;
            game(answerBridge, currentBridge);
        }
    }
}
