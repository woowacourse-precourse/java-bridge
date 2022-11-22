package bridge.controller;

import bridge.constant.GameProgressKeyword;
import bridge.constant.MessageOutput;
import bridge.view.InputView;
import bridge.view.OutputView;

public class AppController {
    BridgeGame bridgeGame;

    void makeBridge() {
        OutputView.printLine(MessageOutput.INTRO);
        OutputView.printLine("");
        OutputView.printLine(MessageOutput.INQUIRE_BRIDGE_LENGTH);
        int size = InputView.readBridgeSize();
        bridgeGame = new BridgeGame(size);
        OutputView.printLine("");
    }

    void crossOver() {
        boolean aRound = true;
        while(aRound) {
            inOrderCrossOver();
            if(bridgeGame.isSuccess()) break;
            if(!inquiryRetry()) break;
            bridgeGame.retry();
        }
    }

    void inOrderCrossOver() {
        boolean movingResult;
        for(int i=0 ; i<bridgeGame.getSize() ; i++) {
            movingResult = calculatePossibleMoving(i);
            OutputView.printMap(bridgeGame.getBridge(), bridgeGame.getUser());
            if(!movingResult) break;
            if(movingResult && (i == bridgeGame.getSize()-1)) bridgeGame.setSuccess();
        }
    }

    boolean calculatePossibleMoving(int index) {
        OutputView.printLine(MessageOutput.INQUIRE_MOVE_BLOCK);
        String input = InputView.readMoving();
        bridgeGame.move(input);
        boolean isSuccess = false;
        if(input.equals(bridgeGame.getIndexResult(index))) {
            isSuccess = true;
        }
        return isSuccess;
    }

    public boolean inquiryRetry() {
        OutputView.printLine(MessageOutput.INQUIRE_REGAIN_GAME);
        String decision = InputView.readGameCommand();
        boolean isRetry = false;
        if(decision.equals(GameProgressKeyword.RETRY_GAME)) {
            isRetry = true;
        }

        return isRetry;
    }

    void showResult() {
        OutputView.printResult(bridgeGame.getBridge(), bridgeGame.getUser());
    }

    public void run() {
        makeBridge();
        crossOver();
        showResult();
    }
}
