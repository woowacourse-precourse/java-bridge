package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.LinkedList;
import java.util.List;

public class StartBridgeGame {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private static final int ZERO = 0;
    private static final String UP_DIRECTION = "U";
    private static final String SPACE = " ";
    private static final String SUCCESS = "성공";
    private static final String FAILURE = "실패";
    private static final String POSSIBILITY_FAILURE = "X";
    private static List<String> bridge;
    private static List<String> checkUpCross;
    private static List<String> checkDownCross;
    private static String direction;
    private static String possibility;
    private static boolean reStart = true;
    private static int tryCount = 0;
    private static String successOrFailure;

    public void run() {
        printStartGame();
        makeBridge(inputView.readBridgeSize());
        progressGame();
        getPrintResult();
    }

    private void printStartGame() {
        outputView.printStartGameNotice();
        outputView.printInputBridgeSizeNotice();
    }

    private void makeBridge(int size) {
        bridge = bridgeMaker.makeBridge(size);
        outputView.printNewLine();
    }

    private void progressGame() {
        while (reStart) {
            tryCount++;
            moveBridge();

            if (reStart) {
                checkReStartGame();
            }

        }
    }

    private void moveBridge() {
        initCheckCross();

        if (!movingBridge()) {
            return;
        }

        successOrFailure = SUCCESS;
        reStart = false;
    }

    private void initCheckCross() {
        checkUpCross = new LinkedList<>();
        checkDownCross = new LinkedList<>();
    }

    private boolean movingBridge() {
        for (int i = ZERO; i < bridge.size(); i++) {
            setDirectionAndPossibility(i);
            getPrintMap();

            if (checkPossibility(possibility)) {
                return false;
            }
        }
        return true;
    }

    private void setDirectionAndPossibility(int index) {
        outputView.printInputMoveDirectionNotice();
        direction = inputView.readMoving();
        possibility = bridgeGame.move(bridge.get(index), direction);
    }

    private void getPrintMap() {
        setUpDownCross(direction, possibility);
        outputView.printMap(checkUpCross, checkDownCross);
    }

    private void setUpDownCross(String direction, String possibility) {
        if (direction.equals(UP_DIRECTION)) {
            checkUpCross.add(possibility);
            checkDownCross.add(SPACE);
            return;
        }
        checkUpCross.add(SPACE);
        checkDownCross.add(possibility);
    }

    private boolean checkPossibility(String possibility) {
        if (possibility.equals(POSSIBILITY_FAILURE)) {
            successOrFailure = FAILURE;
            return true;
        }

        return false;
    }

    private void checkReStartGame() {
        outputView.printReStartGameNotice();
        String gameCommand = inputView.readGameCommand();
        reStart = bridgeGame.retry(gameCommand);
    }

    private void getPrintResult() {
        outputView.printResult(tryCount, successOrFailure);
    }

}
