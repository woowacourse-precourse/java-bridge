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
            if (bridgeGame.move(moveSide, i)) {
                moveSuccess(bridgeGame,moveSide, i);
            }
            if (!bridgeGame.move(moveSide, i)) {
                moveSuccess(bridgeGame,moveSide, i);
            }

        }
        printResult();
    }

    private void replaceBracket(int bracketIndex) {
        if(bracketIndex > 0) {
            upsideResult.replace(BRIDGE_ONE_SPACE_SIZE *bracketIndex, BRIDGE_ONE_SPACE_SIZE *bracketIndex, "|" );
            downsideResult.replace(BRIDGE_ONE_SPACE_SIZE *bracketIndex, BRIDGE_ONE_SPACE_SIZE *bracketIndex, "|" );
        }
    }

    // 맞췄을 때, upside
    private void moveUpside(BridgeGame bridgeGame, String moveSide, int index) {
        upsideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1,bridgeGame.createMoveMark(moveSide, index));
        downsideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1, BRIDGE_ONE_SPACE_BLANK);
        OutputView.printMap(upsideResult, downsideResult);
    }

    // 맞췄을 때, downside
    private void moveDownside(BridgeGame bridgeGame, String moveSide, int index) {
        upsideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1, BRIDGE_ONE_SPACE_BLANK);
        downsideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1,bridgeGame.createMoveMark(moveSide, index));
        OutputView.printMap(upsideResult, downsideResult);
    }

    private void moveFailUpside(BridgeGame bridgeGame, String moveSide, int index) {
        upsideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1,bridgeGame.createMoveMark(moveSide, index));
        downsideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1, BRIDGE_ONE_SPACE_BLANK);
        OutputView.printMap(upsideResult, downsideResult);
    }


    private void moveFailDownside(BridgeGame bridgeGame, String moveSide, int index) {
        upsideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1, BRIDGE_ONE_SPACE_BLANK);
        downsideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1,bridgeGame.createMoveMark(moveSide,index));
        OutputView.printMap(upsideResult, downsideResult);

    }

    private void moveSuccess(BridgeGame bridgeGame, String moveSide, int index) {
        if (bridgeGame.move(moveSide,index) && moveSide.equals("U")) {
            moveUpside(bridgeGame, moveSide, index);
        }
        if (bridgeGame.move(moveSide, index) && moveSide.equals("D")) {
            moveDownside(bridgeGame, moveSide, index);
        }
    }

    private void moveFail(BridgeGame bridgeGame, String moveSide, int index) {
        if (!bridgeGame.move(moveSide, index) && moveSide.equals("U")) {
            moveFailUpside(bridgeGame, moveSide, index);
        }
        if (!bridgeGame.move(moveSide, index) && moveSide.equals("D")) {
            moveFailDownside(bridgeGame, moveSide, index);
        }
    }


    private void printResult() {
        OutputView.printResultMessage();
        OutputView.printMap(upsideResult, downsideResult);
        OutputView.printResult(tryCount, true);
    }
}
