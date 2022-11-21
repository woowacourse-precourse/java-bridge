package bridge;

import java.util.*;

public class Application {
    private static int gameCount = 1;

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
     * 사용자가 이동할 칸을 입력하는 메서드
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
    static List<List<String>> moveBridge(List<String> bridge) {
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();

        while (true) {
            String checkMove = Application.inputMove();
            List<List<String>> moveResult = bridgeGame.move(bridge, checkMove);
            outputView.printMap(moveResult);

            if (bridgeGame.checkBreak(bridge.size())) { return moveResult; }
        }
    }

    /**
     * 사용자가 게임 지속 여부를 입력하는 메서드
     */
    static String inputFinish() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        HandleException handleException = new HandleException();

        outputView.printWantFinish();
        String gameCommand = inputView.readGameCommand();
        String checkCommand = handleException.checkGameCommand(gameCommand);

        return checkCommand;
    }

    /**
     * 게임을 종료하는 메서드
     */
    static Boolean gameEnd(List<List<String>> moveResult) {
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();

        if (!moveResult.get(0).contains("X") && !moveResult.get(1).contains("X")) { outputView.printResult(moveResult, gameCount); return false; }

        String checkCommand = Application.inputFinish();
        if (checkCommand.equals("R")) { gameCount = bridgeGame.retry(gameCount); return true; }
        outputView.printResult(moveResult, gameCount);

        return false;
    }

    public static void main(String[] args) {
        Boolean wholeTry = true;
        try {
            Application.gameStart();
            int bridgeSize = Application.knowBridgeLength();
            List<String> bridge = Application.makeBridge(bridgeSize);
            while (wholeTry) {
                List<List<String>> moveResult = Application.moveBridge(bridge);
                wholeTry = Application.gameEnd(moveResult);
            }
        } catch (IllegalArgumentException e) {}
    }
}
