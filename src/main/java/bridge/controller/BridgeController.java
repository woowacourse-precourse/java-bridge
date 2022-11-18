package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BridgeController {

    private static final int BRIDGE_ONE_SPACE_SIZE = 4;
    private static final String BRIDGE_ONE_SPACE_BLANK = "   ";
    private StringBuilder upSideResult = new StringBuilder("[]");
    private StringBuilder downSideResult = new StringBuilder("[]");
    int tryCount = 1;


    public void run() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        OutputView.printGameStartMessage();
        int bridgeSize = InputView.inputBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridgeResult = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridgeResult, tryCount);
        System.out.println(bridgeResult);
        for (int i = 0; i < bridgeSize; i++) {
            replaceBracket(i);
            String moveSide = Console.readLine();
            moveUp(bridgeGame, moveSide, i);
            moveDown(bridgeGame, moveSide, i);
        }
        printResult();
    }

    private void replaceBracket(int bracketIndex) {
        if(bracketIndex > 0) {
            upSideResult.replace(BRIDGE_ONE_SPACE_SIZE *bracketIndex, BRIDGE_ONE_SPACE_SIZE *bracketIndex, "|" );
            downSideResult.replace(BRIDGE_ONE_SPACE_SIZE *bracketIndex, BRIDGE_ONE_SPACE_SIZE *bracketIndex, "|" );
        }
    }

    private void moveUp(BridgeGame bridgeGame, String moveSide, int index) {
        if (bridgeGame.move(index,moveSide) && moveSide.equals("U")) {
            upSideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1,bridgeGame.successMove(index, moveSide));
            downSideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1, BRIDGE_ONE_SPACE_BLANK);
            OutputView.printMap(upSideResult,downSideResult);
        }
    }

    private void moveDown(BridgeGame bridgeGame, String moveSide, int index) {
        if (bridgeGame.move(index,moveSide) && moveSide.equals("D")) {
            upSideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1, BRIDGE_ONE_SPACE_BLANK);
            downSideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1,bridgeGame.successMove(index, moveSide));
            OutputView.printMap(upSideResult,downSideResult);
        }
    }

    private void printResult() {
        OutputView.printResultMessage();
        OutputView.printMap(upSideResult, downSideResult);
        OutputView.printResult(tryCount, true);
    }
}
