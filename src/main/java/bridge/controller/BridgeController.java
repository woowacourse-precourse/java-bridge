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
    private StringBuilder upsideResult = new StringBuilder("[]");
    private StringBuilder downsideResult = new StringBuilder("[]");
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
            upsideResult.replace(BRIDGE_ONE_SPACE_SIZE *bracketIndex, BRIDGE_ONE_SPACE_SIZE *bracketIndex, "|" );
            downsideResult.replace(BRIDGE_ONE_SPACE_SIZE *bracketIndex, BRIDGE_ONE_SPACE_SIZE *bracketIndex, "|" );
        }
    }

    private void moveUp(BridgeGame bridgeGame, String moveSide, int index) {
        if (bridgeGame.move(index,moveSide) && moveSide.equals("U")) {
            upsideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1,bridgeGame.createMoveMark(index, moveSide));
            downsideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1, BRIDGE_ONE_SPACE_BLANK);
            OutputView.printMap(upsideResult, downsideResult);
        }
    }

    private void moveDown(BridgeGame bridgeGame, String moveSide, int index) {
        if (bridgeGame.move(index,moveSide) && moveSide.equals("D")) {
            upsideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1, BRIDGE_ONE_SPACE_BLANK);
            downsideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1,bridgeGame.createMoveMark(index, moveSide));
            OutputView.printMap(upsideResult, downsideResult);
        }
    }

    private void moveFailUpside(BridgeGame bridgeGame, String moveSide, int index) {
        if (!bridgeGame.move(index,moveSide) && moveSide.equals("U")) {
            upsideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1,bridgeGame.createMoveMark(index, moveSide));
            downsideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1, BRIDGE_ONE_SPACE_BLANK);
            OutputView.printMap(upsideResult, downsideResult);
        }
    }


    private void moveFailDownside(BridgeGame bridgeGame, String moveSide, int index) {
        if (!bridgeGame.move(index,moveSide) && moveSide.equals("D")) {
            upsideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1, BRIDGE_ONE_SPACE_BLANK);
            downsideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1,bridgeGame.createMoveMark(index, moveSide));
            OutputView.printMap(upsideResult, downsideResult);
        }
    }

    private void printResult() {
        OutputView.printResultMessage();
        OutputView.printMap(upsideResult, downsideResult);
        OutputView.printResult(tryCount, true);
    }
}
