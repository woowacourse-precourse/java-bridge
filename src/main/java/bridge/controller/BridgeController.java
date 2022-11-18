package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BridgeController {

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
            upSideResult.replace(4*bracketIndex,4*bracketIndex, "|" );
            downSideResult.replace(4*bracketIndex,4*bracketIndex, "|" );
        }
    }

    private void moveUp(BridgeGame bridgeGame, String moveSide, int index) {
        if (bridgeGame.move(index,moveSide) && moveSide.equals("U")) {
            upSideResult.insert(4*index+1,bridgeGame.successMove(index, moveSide));
            downSideResult.insert(4*index+1, "   ");
            OutputView.printMap(upSideResult,downSideResult);
        }
    }

    private void moveDown(BridgeGame bridgeGame, String moveSide, int index) {
        if (bridgeGame.move(index,moveSide) && moveSide.equals("D")) {
            upSideResult.insert(4*index+1, "   ");
            downSideResult.insert(4*index+1,bridgeGame.successMove(index, moveSide));
            OutputView.printMap(upSideResult,downSideResult);
        }
    }

    private void printResult() {
        OutputView.printResultMessage();
        OutputView.printMap(upSideResult, downSideResult);
        OutputView.printResult(tryCount, true);
    }
}
