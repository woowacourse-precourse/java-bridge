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
    private static final String CLOSING_BRACKET = "]";
    private StringBuilder upsideResult = new StringBuilder("[]");
    private StringBuilder downsideResult = new StringBuilder("[]");
    private boolean BRIDGE_RESULT = true;


    public void run() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        OutputView.printGameStartMessage();
        int bridgeSize = InputView.inputBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridgeMakeResult = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridgeMakeResult, 1);
        for (int i = 0; i < bridgeSize; i++) {
            replaceCloseBracket(i);
            String moveSide = Console.readLine();
            if (bridgeGame.move(moveSide, i)) {
                moveSuccess(bridgeGame,moveSide, i);
                continue;
            }
            if (!bridgeGame.move(moveSide, i)) {
                moveFail(bridgeGame,moveSide, i);
                BRIDGE_RESULT = bridgeGame.retry();
            }
            if (BRIDGE_RESULT) {
                bridgeGame.retryCount();
                goBackOneBridge(i);
                i--;
            }
            if (!BRIDGE_RESULT) {
                break;
            }
        }

        printBridgeResult(BRIDGE_RESULT, bridgeGame.getTryCount());
    }

    private void replaceCloseBracket(int bracketIndex) {
        if(bracketIndex > 0) {
            upsideResult.replace(BRIDGE_ONE_SPACE_SIZE *bracketIndex, BRIDGE_ONE_SPACE_SIZE *bracketIndex, "|" );
            downsideResult.replace(BRIDGE_ONE_SPACE_SIZE *bracketIndex, BRIDGE_ONE_SPACE_SIZE *bracketIndex, "|" );
        }
    }

    private void moveUpside(BridgeGame bridgeGame, String moveSide, int index) {
        upsideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1,bridgeGame.createMoveMark(moveSide, index));
        downsideResult.insert(BRIDGE_ONE_SPACE_SIZE *index+1, BRIDGE_ONE_SPACE_BLANK);
        OutputView.printMap(upsideResult, downsideResult);
    }

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

    private void goBackOneBridge(int index) {
        upsideResult.delete(BRIDGE_ONE_SPACE_SIZE * index , 2*BRIDGE_ONE_SPACE_SIZE*index+1); // i =1 4 ~ 9
        downsideResult.delete(BRIDGE_ONE_SPACE_SIZE * index , 2*BRIDGE_ONE_SPACE_SIZE*index+1);
        upsideResult.append(CLOSING_BRACKET);
        downsideResult.append(CLOSING_BRACKET);
        System.out.println("지운 결과");
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

    // retry에서 R을 입력 받았을 때 다시 시도

    private void printBridgeResult(boolean result, int tryCount) {
        OutputView.printResultMessage();
        OutputView.printMap(upsideResult, downsideResult);
        OutputView.printResult(tryCount, result);
    }
}
