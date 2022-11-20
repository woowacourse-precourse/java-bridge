package bridge;

import java.util.*;

public class Application {
    /**
     * 게임을 시작하는 메서드
     */
    static void gameStart() {
        OutputView outputView = new OutputView();

        outputView.printStart();
    }

    /**
     * 다리 길이를 물어볼 때 사용하는 메서드
     */
    static int knowBridgeLength() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        HandleException handleException = new HandleException();

        outputView.printBridgeLength();
        String readBridgeSize = inputView.readBridgeSize();
        int checkBridgeType = handleException.checkBridgeType(readBridgeSize);
        int checkBridgeRange = handleException.checkBridgeRange(checkBridgeType);

        return checkBridgeRange;
    }

    /**
     * 다리를 만드는 메서드
     */
    static List<String> makeBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        return bridge;
    }

    /**
     * 사용자가 이동할 칸을 입력받는 메서드
     */
    static String inputMove() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        HandleException handleException = new HandleException();

        outputView.printChoiceMove();
        String move = inputView.readMoving();
        String checkMove = handleException.checkMove(move);

        return checkMove;
    }

    /**
     * 다리를 이동하는 메서드
     */
    static void moveBridge(List<String> bridge) {
        BridgeGame bridgeGame = new BridgeGame();
        int index = 0;

        String checkMove = Application.inputMove();
        List<List<String>> moveResult = bridgeGame.move(bridge, index, checkMove);
    }

    public static void main(String[] args) {
        try {
            Application.gameStart();
            int bridgeSize = Application.knowBridgeLength();
            List<String> bridge = Application.makeBridge(bridgeSize);
            Application.moveBridge(bridge);
        } catch (IllegalArgumentException e) {}
    }
}
